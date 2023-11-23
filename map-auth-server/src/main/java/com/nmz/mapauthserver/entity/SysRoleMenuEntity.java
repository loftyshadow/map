package com.nmz.mapauthserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/26-17:45
 */
@Entity
@Table(name = "sys_role_menu", schema = "map", catalog = "")
@IdClass(SysRoleMenuEntityPK.class)
public class SysRoleMenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "menu_id", nullable = false)
    private int menuId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private int roleId;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleMenuEntity that = (SysRoleMenuEntity) o;

        if (menuId != that.menuId) return false;
        if (roleId != that.roleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = menuId;
        result = 31 * result + roleId;
        return result;
    }
}
