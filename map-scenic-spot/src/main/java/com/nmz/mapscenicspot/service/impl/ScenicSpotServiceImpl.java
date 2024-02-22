package com.nmz.mapscenicspot.service.impl;

import com.nmz.mapcommon.utils.JacksonUtils;
import com.nmz.mapscenicspot.dto.ScenicSpotDTO;
import com.nmz.mapscenicspot.entity.ScenicSpotEntity;
import com.nmz.mapscenicspot.mapper.ScenicSpotMapper;
import com.nmz.mapscenicspot.mapper.ScenicSpotRepository;
import com.nmz.mapscenicspot.service.ScenicSpotService;
import com.nmz.mapscenicspot.utils.RedisUtils;
import com.nmz.mapscenicspot.vo.ScenicSpotVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nmz.mapscenicspot.constant.RedisConstantKey.REDIS_HOT_LIST_kEY;
import static com.nmz.mapscenicspot.exception.CityException.CITY_NOT_EXIST_EXCEPTION;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2/22/2024-5:22 PM
 */
@Service
@RequiredArgsConstructor
public class ScenicSpotServiceImpl implements ScenicSpotService {

    private final ScenicSpotRepository scenicSpotRepository;
    private final ScenicSpotMapper scenicSpotMapper;


    @Override
    public List<ScenicSpotVO> getScenicSpotHotList(int count) {
        if (count <= 0) {
            return null;
        }
        return RedisUtils.zrevrange(REDIS_HOT_LIST_kEY, 0, count - 1).stream().toList();
    }

    @Override
    public ScenicSpotVO getScenicSpot(ScenicSpotDTO scenicSpotDTO) {
        ScenicSpotEntity byScenicSpotName = null;
        if (scenicSpotDTO.scenicSpotId() != null) {
            byScenicSpotName = scenicSpotRepository.findById(scenicSpotDTO.scenicSpotId())
                    .orElseThrow(() -> CITY_NOT_EXIST_EXCEPTION);
        }
        if (scenicSpotDTO.scenicSpotName() != null) {
            byScenicSpotName = scenicSpotRepository.findByScenicSpotName(scenicSpotDTO.scenicSpotName());
        }
        // 添加到排行中
        if (byScenicSpotName != null && !byScenicSpotName.getScenicSpotName().isEmpty()) {
            RedisUtils.zincrby(REDIS_HOT_LIST_kEY, JacksonUtils.obj2json(byScenicSpotName), 1);
        }
        return scenicSpotMapper.toScenicSpotVO(byScenicSpotName);
    }
}
