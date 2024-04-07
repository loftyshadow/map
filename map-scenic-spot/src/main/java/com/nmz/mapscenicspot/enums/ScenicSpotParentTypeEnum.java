package com.nmz.mapscenicspot.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description: 景观类型枚举
 * @Author: 聂明智
 * @Date: 2023/12/20-15:24
 */
public enum ScenicSpotParentTypeEnum {

    LAND_SCENERY(1, "地文景观"),
    HYDROLOGICAL_LANDSCAPE(2, "水文景观"),
    BIOLOGICAL_LANDSCAPE(3, "生物景观"),
    METEOROLOGY_AND_ASTRONOMICAL_LANDSCAPE(4, "气象与天象景观"),
    RUINS_AND_RELIC_LANDSCAPE(5, "遗址与遗迹景观"),
    ARCHITECTURE_AND_URBAN_LANDSCAPE(6, "建筑与城市景观"),
    LANDSCAPE_OF_CULTURAL_ACTIVITIES(7, "人文活动景观"),
    DIRECTORY(8, "名录");

    public static Optional<ScenicSpotParentTypeEnum> getSeasonByCode(Integer scenicSpotParentTypeCode) {
        return Arrays.stream(ScenicSpotParentTypeEnum.values())
                .filter(s -> s.scenicSpotParentTypeCode.equals(scenicSpotParentTypeCode))
                .findFirst();
    }

    ScenicSpotParentTypeEnum(Integer scenicSpotParentTypeCode, String scenicSpotParentTypeName) {
        this.scenicSpotParentTypeCode = scenicSpotParentTypeCode;
        this.scenicSpotParentTypeName = scenicSpotParentTypeName;
    }

    private final Integer scenicSpotParentTypeCode;
    private final String scenicSpotParentTypeName;
}
