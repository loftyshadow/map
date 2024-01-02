package com.nmz.mapreview.constant;

/**
 * @Description: es索引枚举
 * @Author: 聂明智
 * @Date: 2024/1/1-22:55
 */
public enum EsindexEnum {

    /**
     * review
     */
    REVIEW("review");

    private final String value;

    public String value() {
        return value;
    }

    EsindexEnum(String value) {
        this.value = value;
    }

}
