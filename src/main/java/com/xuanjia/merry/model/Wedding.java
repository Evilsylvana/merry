package com.xuanjia.merry.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * ����
 * 
 * @author huxuan.hx
 * @version $Id: Wedding.java, v 0.1 2015-9-2 ����5:25:45 huxuan.hx Exp $
 */
public class Wedding implements Serializable {
    /**  */
    private static final long serialVersionUID = 751321760636738836L;

    /**  ����*/
    private String            title;

    /**  ����*/
    private String            bridegroom;

    /**  ����*/
    private String            bride;

    /**  ��ʼʱ��*/
    private Calendar          startTime;

    /**  �ص�*/
    private String            location;

    /**  �ص�ٶȵ�ͼurl*/
    private String            locationBaiDuUrl;

    /**  ���ɵ绰*/
    private String            bridegroomPhone;

    /**  ����绰*/
    private String            bridePhone;

    /**  �ٶȾ�̬��ͼ*/
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
