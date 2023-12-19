package com.nmz.mapscenicspot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ScenicSpotId implements Serializable {
    @Column(name = "scenic_spot_id", nullable = false, unique = true)
    private Long scenicSpotId;

    @Column(name = "city_id", nullable = false, unique = true)
    private Long cityId;

}