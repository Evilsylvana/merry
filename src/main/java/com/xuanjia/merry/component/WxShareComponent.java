package com.xuanjia.merry.component;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xuanjia.merry.init.InitWedding;
import com.xuanjia.merry.utils.HttpUtils;

/**
 * 微信分享
 * 
 * @author huxuan.hx
 * @version $Id: Service.java, v 0.1 2015-9-14 下午9:52:26 huxuan.hx Exp $
 */
public class WxShareComponent {

    private static String TOKEN_KEY  = "access_token";

    private static String TICKET_KEY = "ticket";

    /**  logger*/
    private static Logger logger     = LoggerFactory.getLogger(WxShareComponent.class);

    /**
     * 签名网页
     * 
     * @param url
     */
    public static void signature(String url) {
        if (isSignAvailable()) {
            return;
        }
        //1. 获取accessToken
        genAccessToken();
        //2. 生成js api ticket
        genJSApiTicket();
        //3. 签名网页
        signatureURL(url);
    }

    /**
     * 参与签名的字段包括noncestr（随机字符串）, 
     * 有效的jsapi_ticket, timestamp（时间戳）, url（当前网页的URL，不包含#及其后面部分） 。
     * 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，
     * 使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。
     * 这里需要注意的是所有参数名均为小写字符。对string1作sha1加密，字段名和字段值都采用原始值，不进行URL 转义。
     * 
     * @param url
     */
    private static void signatureURL(String url) {
        if (isEmpty(InitWedding.wxShare.getWxTicket())) {
            return;
        }
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        
        InitWedding.wxShare.setNonceStr(nonce_str);

        InitWedding.wxShare.setSignTimestamp(timestamp);

        String resource = "jsapi_ticket=" + InitWedding.wxShare.getSignature() + "&noncestr="
                          + nonce_str + "&timestamp=" + timestamp + "&url=" + url;
        String target = DigestUtils.sha1Hex(resource);
        InitWedding.wxShare.setSignature(target);
    }

    /**
     * 生成js api ticket
     * 
     */
    private static void genJSApiTicket() {
        if (isEmpty(InitWedding.wxShare.getToken())) {
            return;
        }
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
                     + InitWedding.wxShare.getToken() + "&type=jsapi";
        try {
            String result = HttpUtils.get(url, null);
            JSONObject jsonObject = JSON.parseObject(result);
            if (jsonObject.containsKey(TICKET_KEY)) {
                InitWedding.wxShare.setWxTicket(jsonObject.getString(TICKET_KEY));
            } else {
                logger.error("生成微信访问js api ticket错误, result:" + result);
            }
        } catch (Exception e) {
            logger.error("生成微信访问token错误", e);
        }
    }

    /**
     * 生成token
     * 
     */
    private static void genAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                     + InitWedding.wxShare.getWxAppId() + "&secret="
                     + InitWedding.wxShare.getWxAppSecret();
        try {
            String result = HttpUtils.get(url, null);
            JSONObject jsonObject = JSON.parseObject(result);
            if (jsonObject.containsKey(TOKEN_KEY)) {
                InitWedding.wxShare.setToken(jsonObject.getString(TOKEN_KEY));
                //初始化timestamp
                InitWedding.wxShare.setTimestamp(new Date().getTime());
            } else {
                logger.error("生成微信访问token错误, result:" + result);
            }
        } catch (Exception e) {
            logger.error("生成微信访问token错误", e);
        }
    }

    /**
     * 判断签名是否有效,因只有一个页面，简单处理，不再判断网页,直接对网页进行签名
     * 
     * @return
     */
    private static boolean isSignAvailable() {
        if (null == InitWedding.wxShare.getTimestamp() || 0 == InitWedding.wxShare.getTimestamp()) {
            return false;
        }

        long curTime = new Date().getTime();
        long lastTime = InitWedding.wxShare.getTimestamp();

        // 第一次获得的token有效时间为7200s，判断当前时间比上一次获得的token时间大于1个半小时则重新生成sign
        if ((curTime - lastTime) > 1.5 * 60 * 60 * 1000) {
            return false;
        }
        return true;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    private static boolean isEmpty(String data) {
        return null == data || data.length() == 0;
    }

}
