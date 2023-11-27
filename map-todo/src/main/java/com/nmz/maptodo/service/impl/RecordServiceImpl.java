package com.nmz.maptodo.service.impl;

import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.entity.TodoRecord;
import com.nmz.maptodo.entity.TodoRecordDetail;
import com.nmz.maptodo.entity.TodoRecordDetailId;
import com.nmz.maptodo.mapper.RecordDetailMapper;
import com.nmz.maptodo.mapper.RecordMapper;
import com.nmz.maptodo.mapper.TodoRecordDetailRepository;
import com.nmz.maptodo.mapper.TodoRecordRepository;
import com.nmz.maptodo.service.RecordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-17:50
 */
@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final TodoRecordRepository todoRecordRepository;
    private final TodoRecordDetailRepository todoRecordDetailRepository;
    private final RecordMapper recordMapper;
    private final RecordDetailMapper recordDetailMapper;

    @Override
    @Transactional
    public void addRecord(RecordDTO recordDTO) {
        List<TodoRecordDetail> recordDetailList = recordDetailMapper.toRecordDetailList(recordDTO.recordDetail());
        TodoRecord todoRecord = recordMapper.toRecord(recordDTO);
        TodoRecord save = todoRecordRepository.save(todoRecord);
        recordDetailList.forEach(recordDetail ->
                recordDetail.setId(new TodoRecordDetailId(save.getId())));
        todoRecordDetailRepository.saveAll(recordDetailList);
    }
}
