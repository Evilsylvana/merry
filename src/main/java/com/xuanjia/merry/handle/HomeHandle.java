package com.xuanjia.merry.handle;

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
import com.xuanjia.merry.utils.ReadProperties;

/**
 * 
 * @author huxuan.hx
 * @version $Id: HomeService.java, v 0.1 2015-9-2 ÏÂÎç5:46:11 huxuan.hx Exp $
 */
public class HomeHandle {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeHandle.class);

    private static Wedding      wedding;

    private static Properties   pro;

    static {
        try {
            pro = ReadProperties.getProperties(Contants.DATA_PATH);
            wedding = new Wedding();
            wedding.setTitle(ReadProperties.getValue(pro, Contants.TITLE));
            wedding.setBridegroom(ReadProperties.getValue(pro, Contants.BRIDEGROOM));
            wedding.setBride(ReadProperties.getValue(pro, Contants.BRIDE));
            wedding.setBridegroomPhone(ReadProperties.getValue(pro, Contants.BRIDEGROOM_PHONE));
            wedding.setBridePhone(ReadProperties.getValue(pro, Contants.BRIDE_PHONE));
            wedding.setLocation(ReadProperties.getValue(pro, Contants.LOCALCATION));
            wedding.setLocationBaiDuUrl(ReadProperties
                .getValue(pro, Contants.LOCALCATION_BAIDU_URL));
            wedding.setLocalcationStaticBaiduUrl(ReadProperties.getValue(pro,
                Contants.LOCALCATION_STATIC_BAIDU_URL));
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = dateFormat.parse(ReadProperties.getValue(pro, Contants.TIME));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                wedding.setStartTime(calendar);
            } catch (ParseException e) {
                LOGGER.error(e.getMessage(), e);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
    }

    public static Wedding getWedding() {
        return wedding;
    }

    public static Properties getPro() {
        return pro;
    }
}
