package com.nmz.mapscenicspot.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/19-16:04
 */
@Entity
@Schema(title = "景点")
@Table(name = "scenic_spot", catalog = "")
public class ScenicSpotEntity {
    @EmbeddedId
    private ScenicSpotId scenicSpotId;

    @Schema(title = "景点名称", description = "景点名称")
    @Column(name = "scenic_spot_name")
    private String scenicSpotName;

    @Column(name = "scenic_spot_describe")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String scenicSpotDescribe;

    public String getScenicSpotDescribe() {
        return scenicSpotDescribe;
    }

    public void setScenicSpotDescribe(String scenicSpotDescribe) {
        this.scenicSpotDescribe = scenicSpotDescribe;
    }

    public String getScenicSpotName() {
        return scenicSpotName;
    }

    public void setScenicSpotName(String scenicSpotName) {
        this.scenicSpotName = scenicSpotName;
    }

    public ScenicSpotId getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(ScenicSpotId scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }
}
