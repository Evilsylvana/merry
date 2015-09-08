package com.xuanjia.merry.utils;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * 
 * @author huxuan.hx
 * @version $Id: ConstantsUtil.java, v 0.1 2015-9-2 ÏÂÎç12:45:47 huxuan.hx Exp $
 */
public class ConstantsUtil {
    public static String          CHARSET = "utf-8";

    private static ResourceBundle resourceBundle;

    static {
        resourceBundle = ResourceBundle.getBundle("constants");
    }

    public static int getPropertiesInt(String keyName) {
        String s = resourceBundle.getString(keyName);
        return Integer.valueOf(s);
    }

    public static long getPropertiesLong(String keyName) {
        String s = resourceBundle.getString(keyName);
        return Long.valueOf(s);
    }

    public static String getPropertiesStr(String keyName) {
        return resourceBundle.getString(keyName);
    }

    public static String getPropertiesChStr(String keyName) {
        try {
            return new String(resourceBundle.getString(keyName).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return "";
    }
}
