package com.nmz.maptodo.mapper;

import com.nmz.maptodo.dto.RecordDetailDTO;
import com.nmz.maptodo.entity.PlanRecordDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/25-14:36
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecordDetailMapper {


    @Mapping(source = "checked", target = "detailChecked")
    @Mapping(source = "text", target = "detailText")
    @Mapping(source = "isDelete", target = "detailIsDelete")
    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "detailCreateTime" , ignore = true)
    @Mapping(target = "detailUpdateTime" , ignore = true)
    PlanRecordDetail toRecordDetail(RecordDetailDTO carDto);

    List<PlanRecordDetail> toRecordDetailList(List<RecordDetailDTO> carDto);

}
