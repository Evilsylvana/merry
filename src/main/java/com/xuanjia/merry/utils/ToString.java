package com.xuanjia.merry.utils;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ToString implements Serializable {

    /** serialVersionUID */
    private static final long     serialVersionUID  = 8473762680184447574L;

    /** ������ */
    protected static final String LEFT_PARENTHESIS  = "(";

    /** ������ */
    protected static final String RIGHT_PARENTHESIS = ")";

    /** �ָ���-���� */
    protected static final String COMMA_SEPARATOR   = ",";

    /** 
     * toString������д
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}