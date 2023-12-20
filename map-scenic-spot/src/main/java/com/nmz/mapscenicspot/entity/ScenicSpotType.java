package com.nmz.mapscenicspot.entity;

import com.nmz.mapscenicspot.enums.ScenicSpotParentTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Schema(title = "景点类型", description = "景点类型")
@Table(name = "scenic_spot_type")
public class ScenicSpotType {
    @Id
    @Column(name = "id", nullable = false)
    private Long ScenicSpotTypeId;

    @Schema(title = "景点父类", description = "景点父类具体见ScenicSpotParentTypeEnum")
    @Enumerated
    @Column(name = "scenic_spot_parent_type")
    private ScenicSpotParentTypeEnum scenicSpotParentType;

    @Schema(title = "景点类别名称", description = "景点类别名称")
    @Column(name = "scenic_spot_name")
    private String scenicSpotTypeName;

}