package com.nmz.mapauthserver.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/26-17:45
 */
@Entity
@Table(name = "sys_role", schema = "map", catalog = "")
public class SysRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private long roleId;
    @Basic
    @Column(name = "role_name", nullable = true, length = 255)
    private String roleName;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleEntity that = (SysRoleEntity) o;

        if (roleId != that.roleId) return false;
        return Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        int result = (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
