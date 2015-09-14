package com.xuanjia.merry.model;

import java.io.Serializable;

/**
 * ����
 * 
 * @author huxuan.hx
 * @version $Id: Share.java, v 0.1 2015-9-14 ����9:25:29 huxuan.hx Exp $
 */
public class Share implements Serializable {
    /**  */
    private static final long serialVersionUID = 8739047452386468262L;

    /**  �������*/
    private String            shareTitle;

    /**  ��������*/
    private String            shareDesc;

    private String            shareLink;

    private String            sharePic;

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareDesc() {
        return shareDesc;
    }

    public void setShareDesc(String shareDesc) {
        this.shareDesc = shareDesc;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getSharePic() {
        return sharePic;
    }

    public void setSharePic(String sharePic) {
        this.sharePic = sharePic;
    }

}
