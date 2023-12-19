package com.nmz.mapscenicspot.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/19-16:04
 */
@Entity
public class ScenicSpotEntity {
    @EmbeddedId
    private ScenicSpotId scenicSpotId;

    public ScenicSpotId getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(ScenicSpotId scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }
}
