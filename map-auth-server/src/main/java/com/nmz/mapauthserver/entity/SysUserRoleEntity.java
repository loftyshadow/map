package com.nmz.mapauthserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/28-20:42
 */
@Entity
@jakarta.persistence.Table(name = "sys_user_role", schema = "map", catalog = "")
@jakarta.persistence.IdClass(com.nmz.mapauthserver.entity.SysUserRoleEntityPK.class)
public class SysUserRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private long userId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private long roleId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

        SysUserRoleEntity that = (SysUserRoleEntity) o;

        if (userId != that.userId) return false;
        return roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        return result;
    }
}
