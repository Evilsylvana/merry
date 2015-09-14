package com.xuanjia.merry.handle;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xuanjia.merry.component.WxShareComponent;
import com.xuanjia.merry.init.InitWedding;
import com.xuanjia.merry.model.Wedding;
import com.xuanjia.merry.model.WxShare;

/**
 * 
 * @author huxuan.hx
 * @version $Id: HomeService.java, v 0.1 2015-9-2 ����5:46:11 huxuan.hx Exp $
 */
public class HomeHandle {

    private static Logger logger = LoggerFactory.getLogger(HomeHandle.class);

    public static Wedding getWedding() {
        return InitWedding.getWedding();
    }

    public static WxShare getWxShare(HttpServletRequest request) {
        WxShare share = InitWedding.wxShare;
        String strBackUrl = request.getScheme() + "://"
                            + request.getHeader("host") //��������ַ  
                            + request.getRequestURI() //��Ŀ����  
                            + (request.getQueryString() == null ? "" : "?"
                                                                       + (request.getQueryString())); //���� 
        logger.info(strBackUrl);
        WxShareComponent.signature(strBackUrl);
        return share;
    }
}
