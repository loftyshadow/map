package com.nmz.mapscenicspot.mapper;

import com.nmz.mapscenicspot.dto.ScenicSpotTypeDTO;
import com.nmz.mapscenicspot.entity.ScenicSpotTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/21-14:21
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScenicSpotTypeMapper {

    ScenicSpotTypeEntity toScenicSpotTypeEntity(ScenicSpotTypeDTO scenicSpotTypeDTO);

    List<ScenicSpotTypeEntity> toScenicSpotTypeEntityList(List<ScenicSpotTypeDTO> scenicSpotTypeDTOS);

}
