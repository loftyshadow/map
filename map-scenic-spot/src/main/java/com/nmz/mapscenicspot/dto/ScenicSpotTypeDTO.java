package com.nmz.mapscenicspot.dto;

import com.nmz.mapscenicspot.enums.ScenicSpotParentTypeEnum;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/21-14:03
 */

public record ScenicSpotTypeDTO(int scenicSpotTypeId,
                                ScenicSpotParentTypeEnum scenicSpotParentType,
                                String scenicSpotTypeName) {
}
