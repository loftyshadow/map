package com.nmz.mapscenicspot.entity;

import com.nmz.mapscenicspot.enums.ScenicSpotParentTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Schema(title = "景点类型", description = "景点类型")
@Table(name = "scenic_spot_type")
public class ScenicSpotTypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "scenic_spot_type_id", nullable = false)
    private Long scenicSpotTypeId;

    @Schema(title = "景点类别父类", description = "景点类别父类具体见ScenicSpotParentTypeEnum")
    @Enumerated
    @Column(name = "scenic_spot_parent_type")
    private ScenicSpotParentTypeEnum scenicSpotParentType;

    @Schema(title = "景点类别名称", description = "景点类别名称")
    @Column(name = "scenic_spot_name")
    private String scenicSpotTypeName;

    public Long getScenicSpotTypeId() {
        return scenicSpotTypeId;
    }

    public void setScenicSpotTypeId(Long scenicSpotTypeId) {
        this.scenicSpotTypeId = scenicSpotTypeId;
    }

    public ScenicSpotParentTypeEnum getScenicSpotParentType() {
        return scenicSpotParentType;
    }

    public void setScenicSpotParentType(ScenicSpotParentTypeEnum scenicSpotParentType) {
        this.scenicSpotParentType = scenicSpotParentType;
    }

    public String getScenicSpotTypeName() {
        return scenicSpotTypeName;
    }

    public void setScenicSpotTypeName(String scenicSpotTypeName) {
        this.scenicSpotTypeName = scenicSpotTypeName;
    }
}