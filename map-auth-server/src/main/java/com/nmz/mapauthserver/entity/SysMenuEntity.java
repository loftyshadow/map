package com.nmz.mapauthserver.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/27-21:06
 */
@Data
@ToString
@Entity
@Table(name = "sys_menu", schema = "map", catalog = "")
public class SysMenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "menu_id", nullable = false)
    private int menuId;
    @Basic
    @Column(name = "parent_id", nullable = false)
    private int parentId;
    @Basic
    @Column(name = "component", nullable = true, length = 255)
    private String component;
    @Basic
    @Column(name = "path", nullable = false, length = 255)
    private String path;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "redirect", nullable = true, length = 255)
    private String redirect;
    @Basic
    @Column(name = "icon", nullable = true, length = 255)
    private String icon;
    @Basic
    @Column(name = "title", nullable = true, length = 255)
    private String title;
    @Basic
    @Column(name = "active_menu", nullable = true, length = 255)
    private String activeMenu;
    @Basic
    @Column(name = "is_link", nullable = true, length = 255)
    private String isLink;
    @Basic
    @Column(name = "is_hide", nullable = true, length = 255)
    private Boolean isHide;
    @Basic
    @Column(name = "is_full", nullable = true, length = 255)
    private Boolean isFull;
    @Basic
    @Column(name = "is_affix", nullable = true, length = 255)
    private Boolean isAffix;
    @Basic
    @Column(name = "is_keep_alive", nullable = true, length = 255)
    private Boolean isKeepAlive;

}
