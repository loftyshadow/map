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
 * @Date: 2023/9/26-17:46
 */
@Entity
@Table(name = "sys_role_resources", schema = "map", catalog = "")
@IdClass(SysRoleResourcesEntityPK.class)
public class SysRoleResourcesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "resource_id", nullable = false)
    private long resourceId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private long roleId;

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleResourcesEntity that = (SysRoleResourcesEntity) o;

        if (resourceId != that.resourceId) return false;
        return roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        int result = (int) (resourceId ^ (resourceId >>> 32));
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        return result;
    }
}
