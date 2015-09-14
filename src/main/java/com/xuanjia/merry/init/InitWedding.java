package com.xuanjia.merry.init;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xuanjia.merry.constant.Contants;
import com.xuanjia.merry.model.Wedding;
import com.xuanjia.merry.model.WxShare;
import com.xuanjia.merry.utils.ReadProperties;

/**
 * 初始化婚礼
 * 
 * @author huxuan.hx
 * @version $Id: HomeService.java, v 0.1 2015-9-2 下午5:46:11 huxuan.hx Exp $
 */
public class InitWedding {

    public static Wedding     wedding;

    private static Properties weddingConfig;

    private static Properties wxConfig;

    public static WxShare     wxShare;

    public static Logger      LOGGER = LoggerFactory.getLogger(InitWedding.class);

    static {
        try {
            weddingConfig = ReadProperties.getProperties(Contants.DATA_PATH);
            wxConfig = ReadProperties.getProperties(Contants.SHARE_DATA_PATH);
            initWedding();
            initWxShare();
        } catch (FileNotFoundException e) {
            LOGGER.error("", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
    }

    /**
     * 初始化婚礼配置文件
     * 
     */
    public static void initWedding() {
        wedding = new Wedding();
        wedding.setTitle(ReadProperties.getValue(weddingConfig, Contants.TITLE));
        wedding.setBridegroom(ReadProperties.getValue(weddingConfig, Contants.BRIDEGROOM));
        wedding.setBride(ReadProperties.getValue(weddingConfig, Contants.BRIDE));
        wedding.setBridegroomPhone(ReadProperties
            .getValue(weddingConfig, Contants.BRIDEGROOM_PHONE));
        wedding.setBridePhone(ReadProperties.getValue(weddingConfig, Contants.BRIDE_PHONE));
        wedding.setLocation(ReadProperties.getValue(weddingConfig, Contants.LOCALCATION));
        wedding.setLocationBaiDuUrl(ReadProperties.getValue(weddingConfig,
            Contants.LOCALCATION_BAIDU_URL));
        wedding.setLocalcationStaticBaiduUrl(ReadProperties.getValue(weddingConfig,
            Contants.LOCALCATION_STATIC_BAIDU_URL));
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormat.parse(ReadProperties.getValue(weddingConfig, Contants.TIME));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            wedding.setStartTime(calendar);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static void initWxShare() {
        wxShare = new WxShare();
        wxShare.setShareTitle(ReadProperties.getValue(wxConfig, Contants.SHARE_TITLE));
        wxShare.setShareDesc(ReadProperties.getValue(wxConfig, Contants.SHARE_DESC));
        wxShare.setSharePic(ReadProperties.getValue(wxConfig, Contants.SHARE_PIC));
        wxShare.setShareLink(ReadProperties.getValue(wxConfig, Contants.SHARE_LINK));
        wxShare.setWxAppId(ReadProperties.getValue(wxConfig, Contants.WX_APP_ID));
        wxShare.setWxAppSecret(ReadProperties.getValue(wxConfig, Contants.WX_APP_SECRET));
    }

    public static Wedding getWedding() {
        return wedding;
    }

    public static Properties getPro() {
        return weddingConfig;
    }
}
