package com.xuanjia.merry.utils;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ToString implements Serializable {

    /** serialVersionUID */
    private static final long     serialVersionUID  = 8473762680184447574L;

    /** ×óÀ¨ºÅ */
    protected static final String LEFT_PARENTHESIS  = "(";

    /** ÓÒÀ¨ºÅ */
    protected static final String RIGHT_PARENTHESIS = ")";

    /** ·Ö¸ô·û-¶ººÅ */
    protected static final String COMMA_SEPARATOR   = ",";

    /** 
     * toString·½·¨ÖØÐ´
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}