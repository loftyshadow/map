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
@Table(name = "sys_resource", schema = "map", catalog = "")
public class SysResourceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "resource_id", nullable = false)
    private long resourceId;
    @Basic
    @Column(name = "resource_name", nullable = true, length = 255)
    private String resourceName;
    @Basic
    @Column(name = "resource_url", nullable = true, length = 255)
    private String resourceUrl;
    @Basic
    @Column(name = "resource_method", nullable = true, length = 255)
    private String resourceMethod;

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceMethod() {
        return resourceMethod;
    }

    public void setResourceMethod(String resourceMethod) {
        this.resourceMethod = resourceMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysResourceEntity that = (SysResourceEntity) o;

        if (resourceId != that.resourceId) return false;
        if (!Objects.equals(resourceName, that.resourceName)) return false;
        if (!Objects.equals(resourceUrl, that.resourceUrl)) return false;
        return Objects.equals(resourceMethod, that.resourceMethod);
    }

    @Override
    public int hashCode() {
        int result = (int) (resourceId ^ (resourceId >>> 32));
        result = 31 * result + (resourceName != null ? resourceName.hashCode() : 0);
        result = 31 * result + (resourceUrl != null ? resourceUrl.hashCode() : 0);
        result = 31 * result + (resourceMethod != null ? resourceMethod.hashCode() : 0);
        return result;
    }
}
