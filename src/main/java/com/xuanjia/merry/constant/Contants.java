package com.xuanjia.merry.constant;

import com.xuanjia.merry.utils.ConstantsUtil;

/**
 * 常量
 * 
 * @author huxuan.hx
 * @version $Id: Contants.java, v 0.1 2015-9-2 下午1:41:45 huxuan.hx Exp $
 */
public class Contants {
    /**  */
    public static String DATA_PATH                    = ConstantsUtil.getPropertiesStr("data_path");

    public static String SHARE_DATA_PATH              = ConstantsUtil
                                                          .getPropertiesStr("share_path");

    /**  新郎key*/
    public static String BRIDEGROOM                   = "bridegroom";

    /**  新娘key*/
    public static String BRIDE                        = "bride";

    /**  标题*/
    public static String TITLE                        = "title";

    /**  地点*/
    public static String LOCALCATION                  = "localcation";

    /**  百度地图链接*/
    public static String LOCALCATION_BAIDU_URL        = "localcation_baidu_url";

    /**  时间*/
    public static String TIME                         = "time";

    public static String BRIDE_PHONE                  = "bride_phone";

    public static String BRIDEGROOM_PHONE             = "bridegroom_phone";

    public static String LOCALCATION_STATIC_BAIDU_URL = "localcation_static_baidu_url";

    /**  分享标题*/
    public static String SHARE_TITLE                  = "share_title";

    /**  分享描述*/
    public static String SHARE_DESC                   = "share_desc";

    public static String SHARE_LINK                   = "share_link";

    public static String SHARE_PIC                    = "share_pic";

    public static String WX_APP_ID                    = "app_id";

    public static String WX_APP_SECRET                = "app_secret";
}
