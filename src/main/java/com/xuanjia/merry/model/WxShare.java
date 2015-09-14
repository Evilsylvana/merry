package com.xuanjia.merry.model;

/**
 * 微信分享
 * 
 * @author huxuan.hx
 * @version $Id: WxShare.java, v 0.1 2015-9-14 下午9:27:49 huxuan.hx Exp $
 */
public class WxShare extends Share {

    /**  */
    private static final long serialVersionUID = -3740993140662388756L;

    /**  微信token*/
    private String            token;

    /**  生成token的时间戳*/
    private Long              timestamp;

    /**  生成signature的随机字符串*/
    private String            nonceStr;

    /**  分享中需要的网页签名字符串*/
    private String            signature;

    /**  微信公众号id*/
    private String            wxAppId;

    /**  微信公众号密匙*/
    private String            wxAppSecret;

    /**  微信ticket*/
    private String            wxTicket;

    private String            signTimestamp;

    private String            host;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxAppSecret() {
        return wxAppSecret;
    }

    public void setWxAppSecret(String wxAppSecret) {
        this.wxAppSecret = wxAppSecret;
    }

    public String getWxTicket() {
        return wxTicket;
    }

    public void setWxTicket(String wxTicket) {
        this.wxTicket = wxTicket;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignTimestamp() {
        return signTimestamp;
    }

    public void setSignTimestamp(String signTimestamp) {
        this.signTimestamp = signTimestamp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
