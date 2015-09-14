package com.xuanjia.merry.model;

import java.io.Serializable;

/**
 * 分享
 * 
 * @author huxuan.hx
 * @version $Id: Share.java, v 0.1 2015-9-14 下午9:25:29 huxuan.hx Exp $
 */
public class Share implements Serializable {
    /**  */
    private static final long serialVersionUID = 8739047452386468262L;

    /**  分享标题*/
    private String            shareTitle;

    /**  分享描述*/
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
