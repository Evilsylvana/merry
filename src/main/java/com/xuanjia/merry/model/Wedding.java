package com.xuanjia.merry.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * 婚礼
 * 
 * @author huxuan.hx
 * @version $Id: Wedding.java, v 0.1 2015-9-2 下午5:25:45 huxuan.hx Exp $
 */
public class Wedding implements Serializable {
    /**  */
    private static final long serialVersionUID = 751321760636738836L;

    /**  标题*/
    private String            title;

    /**  新郎*/
    private String            bridegroom;

    /**  新娘*/
    private String            bride;

    /**  开始时间*/
    private Calendar          startTime;

    /**  地点*/
    private String            location;

    /**  地点百度地图url*/
    private String            locationBaiDuUrl;

    /**  新郎电话*/
    private String            bridegroomPhone;

    /**  新娘电话*/
    private String            bridePhone;

    /**  百度静态地图*/
    private String            localcationStaticBaiduUrl;

    public String getBridegroom() {
        return bridegroom;
    }

    public void setBridegroom(String bridegroom) {
        this.bridegroom = bridegroom;
    }

    public String getBride() {
        return bride;
    }

    public void setBride(String bride) {
        this.bride = bride;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationBaiDuUrl() {
        return locationBaiDuUrl;
    }

    public void setLocationBaiDuUrl(String locationBaiDuUrl) {
        this.locationBaiDuUrl = locationBaiDuUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBridePhone() {
        return bridePhone;
    }

    public void setBridePhone(String bridePhone) {
        this.bridePhone = bridePhone;
    }

    public String getBridegroomPhone() {
        return bridegroomPhone;
    }

    public void setBridegroomPhone(String bridegroomPhone) {
        this.bridegroomPhone = bridegroomPhone;
    }

    public String getLocalcationStaticBaiduUrl() {
        return localcationStaticBaiduUrl;
    }

    public void setLocalcationStaticBaiduUrl(String localcationStaticBaiduUrl) {
        this.localcationStaticBaiduUrl = localcationStaticBaiduUrl;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

}
