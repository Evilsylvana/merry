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
 * ΢�ŷ���
 * 
 * @author huxuan.hx
 * @version $Id: Service.java, v 0.1 2015-9-14 ����9:52:26 huxuan.hx Exp $
 */
public class WxShareComponent {

    private static String TOKEN_KEY  = "access_token";

    private static String TICKET_KEY = "ticket";

    /**  logger*/
    private static Logger logger     = LoggerFactory.getLogger(WxShareComponent.class);

    /**
     * ǩ����ҳ
     * 
     * @param url
     */
    public static void signature(String url) {
        if (isSignAvailable()) {
            return;
        }
        //1. ��ȡaccessToken
        genAccessToken();
        //2. ����js api ticket
        genJSApiTicket();
        //3. ǩ����ҳ
        signatureURL(url);
    }

    /**
     * ����ǩ�����ֶΰ���noncestr������ַ�����, 
     * ��Ч��jsapi_ticket, timestamp��ʱ�����, url����ǰ��ҳ��URL��������#������沿�֣� ��
     * �����д�ǩ�����������ֶ�����ASCII ���С���������ֵ��򣩺�
     * ʹ��URL��ֵ�Եĸ�ʽ����key1=value1&key2=value2����ƴ�ӳ��ַ���string1��
     * ������Ҫע��������в�������ΪСд�ַ�����string1��sha1���ܣ��ֶ������ֶ�ֵ������ԭʼֵ��������URL ת�塣
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
     * ����js api ticket
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
                logger.error("����΢�ŷ���js api ticket����, result:" + result);
            }
        } catch (Exception e) {
            logger.error("����΢�ŷ���token����", e);
        }
    }

    /**
     * ����token
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
                //��ʼ��timestamp
                InitWedding.wxShare.setTimestamp(new Date().getTime());
            } else {
                logger.error("����΢�ŷ���token����, result:" + result);
            }
        } catch (Exception e) {
            logger.error("����΢�ŷ���token����", e);
        }
    }

    /**
     * �ж�ǩ���Ƿ���Ч,��ֻ��һ��ҳ�棬�򵥴��������ж���ҳ,ֱ�Ӷ���ҳ����ǩ��
     * 
     * @return
     */
    private static boolean isSignAvailable() {
        if (null == InitWedding.wxShare.getTimestamp() || 0 == InitWedding.wxShare.getTimestamp()) {
            return false;
        }

        long curTime = new Date().getTime();
        long lastTime = InitWedding.wxShare.getTimestamp();

        // ��һ�λ�õ�token��Чʱ��Ϊ7200s���жϵ�ǰʱ�����һ�λ�õ�tokenʱ�����1����Сʱ����������sign
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
