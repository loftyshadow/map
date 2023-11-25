package com.nmz.maptodo.mapper;

import com.nmz.maptodo.dto.RecordDetailDTO;
import com.nmz.maptodo.entity.TodoRecordDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/25-14:36
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecordMapper {

    @Mapping(source = "detailChecked", target = "checked")
    @Mapping(source = "detailText", target = "text")
    @Mapping(source = "detailIsDelete", target = "isDelete")
    RecordDetailDTO toRecordDetail(TodoRecordDetail todoRecordDetail);

}
