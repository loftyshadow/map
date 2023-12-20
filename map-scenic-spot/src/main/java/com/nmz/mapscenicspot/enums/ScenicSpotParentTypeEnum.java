package com.nmz.mapscenicspot.enums;

/**
 * @Description: 景观类型枚举
 * @Author: 聂明智
 * @Date: 2023/12/20-15:24
 */
public enum ScenicSpotParentTypeEnum {

    LAND_SCENERY("地文景观"),
    HYDROLOGICAL_LANDSCAPE("水文景观"),
    BIOLOGICAL_LANDSCAPE("生物景观"),
    METEOROLOGY_AND_ASTRONOMICAL_LANDSCAPE("气象与天象景观"),
    RUINS_AND_RELIC_LANDSCAPE("遗址与遗迹景观"),
    ARCHITECTURE_AND_URBAN_LANDSCAPE("建筑与城市景观"),
    LANDSCAPE_OF_CULTURAL_ACTIVITIES("人文活动景观"),
    DIRECTORY("名录");


    ScenicSpotParentTypeEnum(String scenicSpotParentTypeName) {
        this.scenicSpotParentTypeName = scenicSpotParentTypeName;
    }

    private final String scenicSpotParentTypeName;
}
