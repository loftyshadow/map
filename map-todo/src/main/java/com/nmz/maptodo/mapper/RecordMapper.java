package com.nmz.maptodo.mapper;

import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.entity.TodoRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/27-9:10
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecordMapper {

    @Mapping(source = "id", target = "id.recordId")
    @Mapping(source = "userId", target = "id.userId")
    @Mapping(source = "locked", target = "recordLocked")
    @Mapping(source = "title", target = "recordTitle")
    @Mapping(source = "isDelete", target = "recordIsDelete")
    @Mapping(target = "recordCreateTime", ignore = true)
    @Mapping(target = "recordUpdateTime", ignore = true)
    TodoRecord toRecord(RecordDTO recordDTO);

}
