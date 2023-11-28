package com.nmz.maptodo.service;

import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.dto.RecordDetailDTO;
import com.nmz.maptodo.entity.TodoRecord;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-17:50
 */
public interface RecordService {

    void addRecord(RecordDTO recordDTO);

    void updateRecord(RecordDTO recordDTO, Long todoId);
}
