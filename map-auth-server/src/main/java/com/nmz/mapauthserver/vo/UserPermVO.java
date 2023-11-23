package com.nmz.mapauthserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Description: 用户动态路由
 * @Author: 聂明智
 * @Date: 2023/9/25-16:26
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPermVO {
    private Integer menuId;
    private String component;
    private String title;
    private String icon;
    private Boolean isShow;
    private Boolean isShowBreadCrumb;
    private List<UserPermVO> children;

}
