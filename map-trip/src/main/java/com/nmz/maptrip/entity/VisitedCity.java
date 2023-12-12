package com.nmz.maptrip.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

/**
 * @Description: 旅游过的城市
 * @Author: 聂明智
 * @Date: 2023/12/6-17:42
 */
@Entity
@Schema(title = "旅游过的城市", description = "旅游过的城市")
public class VisitedCity {
    @EmbeddedId
    private VisitedCityId visitedCityId;

    @Schema(name = "城市名称", description = "城市名称", example = "北京")
    @Column(name = "visited_city_name")
    private String visitedCityName;

    @Temporal(TemporalType.DATE)
    @Column(name = "visit_city_time")
    private Date visitCityTime;

    public Date getVisitCityTime() {
        return visitCityTime;
    }

    public void setVisitCityTime(Date visitCityTime) {
        this.visitCityTime = visitCityTime;
    }

    public String getVisitedCityName() {
        return visitedCityName;
    }

    public void setVisitedCityName(String visitedCityName) {
        this.visitedCityName = visitedCityName;
    }

    public VisitedCityId getVisitedCityId() {
        return visitedCityId;
    }

    public void setVisitedCityId(VisitedCityId visitedCityId) {
        this.visitedCityId = visitedCityId;
    }
}
