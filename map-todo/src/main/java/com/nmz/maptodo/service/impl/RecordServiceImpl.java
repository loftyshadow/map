package com.nmz.maptodo.service.impl;

import com.nmz.maptodo.entity.TodoRecord;
import com.nmz.maptodo.mapper.TodoRecordRepository;
import com.nmz.maptodo.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-17:50
 */
@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final TodoRecordRepository todoRecordRepository;

    @Override
    public void addRecord(TodoRecord todoRecord) {
        todoRecordRepository.save(todoRecord);
    }
}
