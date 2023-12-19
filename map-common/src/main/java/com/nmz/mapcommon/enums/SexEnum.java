package com.nmz.mapcommon.enums;

/**
 * @Description: 性别
 * @Author: 聂明智
 * @Date: 2023/11/22-14:16
 */
public enum SexEnum {
    MAN("男"),
    WOMAN("女");

    private final String sex;

    SexEnum(String sex) {
        this.sex = sex;
    }
}
