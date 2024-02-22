package com.nmz.mapscenicspot.dto;

import com.nmz.mapscenicspot.entity.ScenicSpotId;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2/22/2024-5:18 PM
 */
public record ScenicSpotDTO(ScenicSpotId scenicSpotId,
                            String scenicSpotDescribe,
                            String scenicSpotName
){
}
