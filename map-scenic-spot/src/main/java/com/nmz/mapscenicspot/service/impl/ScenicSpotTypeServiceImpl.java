package com.nmz.mapscenicspot.service.impl;

import com.nmz.mapscenicspot.dto.ScenicSpotTypeDTO;
import com.nmz.mapscenicspot.entity.ScenicSpotTypeEntity;
import com.nmz.mapscenicspot.mapper.ScenicSpotTypeMapper;
import com.nmz.mapscenicspot.mapper.ScenicSpotTypeRepository;
import com.nmz.mapscenicspot.service.ScenicSpotTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/21-13:57
 */
@Service
@RequiredArgsConstructor
public class ScenicSpotTypeServiceImpl implements ScenicSpotTypeService {

    private final ScenicSpotTypeRepository scenicSpotTypeRepository;
    private final ScenicSpotTypeMapper scenicSpotTypeMapper;

    @Override
    public void addScenicSpotType(ScenicSpotTypeDTO scenicSpotTypeDTO) {
        ScenicSpotTypeEntity scenicSpotType = scenicSpotTypeMapper.toScenicSpotTypeEntity(scenicSpotTypeDTO);
        scenicSpotTypeRepository.save(scenicSpotType);
    }
}
