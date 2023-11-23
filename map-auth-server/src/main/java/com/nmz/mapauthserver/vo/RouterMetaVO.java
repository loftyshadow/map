package com.nmz.mapauthserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 路由元信息
 * @Author: 聂明智
 * @Date: 2023/10/13-14:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouterMetaVO {
    /** 菜单和面包屑对应的图标 */
    private String icon;
    /** 路由标题 (用作 document.title || 菜单的名称) */
    private String title;
    /** 是否在菜单中隐藏, 需要高亮的 path (通常用作详情页高亮父级菜单) */
    private String activeMenu;
    /** 路由外链时填写的访问地址 */
    private String isLink;
    /** 是否在菜单中隐藏 (通常列表详情页需要隐藏) */
    private Boolean isHide;
    /** 菜单是否全屏 (示例：数据大屏页面) */
    private Boolean isFull;
    /** 菜单是否固定在标签页中 (首页通常是固定项) */
    private Boolean isAffix;
    /** 当前路由是否缓存 */
    private Boolean isKeepAlive;
}
