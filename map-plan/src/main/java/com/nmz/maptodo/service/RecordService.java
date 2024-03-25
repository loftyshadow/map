package com.nmz.maptodo.service;

import com.nmz.maptodo.dto.RecordDTO;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-17:50
 */
public interface RecordService {

    void addRecord(RecordDTO recordDTO, Long userId);

    void updateRecord(RecordDTO recordDTO, Long todoId);
}
