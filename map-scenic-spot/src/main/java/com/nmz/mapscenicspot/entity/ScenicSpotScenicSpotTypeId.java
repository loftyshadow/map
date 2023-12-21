package com.nmz.mapscenicspot.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@Schema(title = "景点景点类型关联表")
public class ScenicSpotScenicSpotTypeId implements Serializable {

    @Column(name = "scenic_spot_id", nullable = false)
    private Long scenicSpotId;

    @Column(name = "scenic_spot_type_id", nullable = false)
    private Long ScenicSpotTypeId;

}