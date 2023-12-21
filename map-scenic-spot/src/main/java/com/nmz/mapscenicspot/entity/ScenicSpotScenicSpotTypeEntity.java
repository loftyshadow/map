package com.nmz.mapscenicspot.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "scenic_spot_scenic_spot_type")
public class ScenicSpotScenicSpotTypeEntity {

    @EmbeddedId
    private ScenicSpotScenicSpotTypeId scenicSpotScenicSpotTypeId;

}