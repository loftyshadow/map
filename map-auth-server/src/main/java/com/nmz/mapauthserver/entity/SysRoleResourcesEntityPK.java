package com.nmz.mapauthserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/26-17:46
 */
@Data
public class SysRoleResourcesEntityPK implements Serializable {
    @Column(name = "role_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    @Column(name = "resource_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleResourcesEntityPK that = (SysRoleResourcesEntityPK) o;

        if (roleId != that.roleId) return false;
        if (resourceId != that.resourceId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resourceId;
        result = 31 * result + roleId;
        return result;
    }
}
