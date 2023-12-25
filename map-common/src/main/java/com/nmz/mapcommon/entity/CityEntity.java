package com.nmz.mapcommon.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @Description: 所有的城市
 * @Author: 聂明智
 * @Date: 2023/12/17-0:10
 */
@Entity
@Table(name = "city", schema = "map", catalog = "")
@Schema(title = "所有的城市", description = "可获取的全部城市，根据父城市id实现层级效果")
public class CityEntity {
    @Id
    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Schema(title = "父城市id", description = "第一级城市（省/直辖市）为0")
    @Column(name = "parent_city_id")
    private Long parentCityId;

    @Schema(title = "城市名称")
    @Column(name = "city_name")
    private String cityName;

    public Long getParentCityId() {
        return parentCityId;
    }

    public void setParentCityId(Long parentCityId) {
        this.parentCityId = parentCityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
