package com.nmz.mapscenicspot.mapper;

import com.nmz.mapscenicspot.dto.ScenicSpotDTO;
import com.nmz.mapscenicspot.dto.ScenicSpotTypeDTO;
import com.nmz.mapscenicspot.entity.ScenicSpotEntity;
import com.nmz.mapscenicspot.vo.ScenicSpotVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2/22/2024-5:32 PM
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScenicSpotMapper {

    ScenicSpotEntity toScenicSpotEntity(ScenicSpotDTO scenicSpotDTO);

    List<ScenicSpotEntity> toScenicSpotEntityList(List<ScenicSpotDTO> scenicSpotDTOS);

    ScenicSpotVO toScenicSpotVO(ScenicSpotEntity scenicSpotEntity);

    List<ScenicSpotVO> toScenicSpotVOList(List<ScenicSpotEntity> scenicSpotEntities);
}
