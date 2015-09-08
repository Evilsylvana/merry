package com.xuanjia.merry.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author huxuan.hx
 * @version $Id: ReadProperties.java, v 0.1 2015-9-2 ����1:29:12 huxuan.hx Exp $
 */
public class ReadProperties {

    private static Logger logger = LoggerFactory.getLogger(ReadProperties.class);

    /**
     * ��ȡ���������ļ�
     * 
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Properties getProperties(String path) throws FileNotFoundException, IOException {
        Properties props = null;
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            props = new Properties();
            props.load(new FileInputStream(file));
        } else {
            logger.warn(file.toString() + "�����ڣ�");
        }
        return props;
    }

    /**
     * �������ļ���ȡֵ 
     * 
     * @param props
     * @param key
     * @return
     */
    public static String getValue(Properties props, String key) {
        return getValue(props, key, "");
    }

    /** 
     * �������ļ���ȡֵ 
     * 
     * @param props Properties Object 
     * @param key 
     * @return ͨ��keyƥ�䵽��value 
     */
    public static String getValue(Properties props, String key, String encod) {
        String result = "";
        String en = "";
        String localEN = System.getProperty("file.encoding");
        if (encod != null && !encod.equals("")) {
            en = encod;
        } else {
            en = localEN;
        }
        try {
            key = new String(key.getBytes(en), "ISO-8859-1");
            result = props.getProperty(key);
            if (!result.equals("")) {
                result = new String(result.getBytes("ISO-8859-1"), en);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (result == null) {
                result = "";
            }
        }
        return result;
    }
}
