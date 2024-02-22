package com.nmz.mapscenicspot.service;

import com.nmz.mapscenicspot.dto.ScenicSpotDTO;
import com.nmz.mapscenicspot.vo.ScenicSpotVO;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2/22/2024-5:21 PM
 */
public interface ScenicSpotService {
    ScenicSpotVO getScenicSpot(ScenicSpotDTO scenicSpotDTO);

    List<ScenicSpotVO> getScenicSpotHotList(int count);
}
