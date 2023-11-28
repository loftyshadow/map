package com.nmz.maptodo.service.impl;

import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.entity.TodoRecord;
import com.nmz.maptodo.entity.TodoRecordDetail;
import com.nmz.maptodo.entity.TodoRecordDetailId;
import com.nmz.maptodo.entity.TodoRecordId;
import com.nmz.maptodo.mapper.RecordDetailMapper;
import com.nmz.maptodo.mapper.RecordMapper;
import com.nmz.maptodo.mapper.TodoRecordDetailRepository;
import com.nmz.maptodo.mapper.TodoRecordRepository;
import com.nmz.maptodo.service.RecordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.nmz.maptodo.constant.RedissonKeyConstant.TODO_RECORD_REDISSON_KEY;

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
    private final RedissonClient redissonClient;

    @Override
    @Transactional
    public void addRecord(RecordDTO recordDTO, Long userId) {
        List<TodoRecordDetail> recordDetailList = recordDetailMapper.toRecordDetailList(recordDTO.recordDetail());
        TodoRecord todoRecord = recordMapper.toRecord(recordDTO);
        todoRecord.setId(new TodoRecordId(userId, null));
        TodoRecord save = todoRecordRepository.save(todoRecord);
        recordDetailList.forEach(recordDetail ->
                recordDetail.setId(new TodoRecordDetailId(save.getId().getRecordId())));
        todoRecordDetailRepository.saveAll(recordDetailList);
    }

    @Override
    @Transactional
    public void updateRecord(RecordDTO recordDTO, Long todoId) {
        Long userId = recordDTO.userId();
        String redissonKey = TODO_RECORD_REDISSON_KEY.formatted(userId, todoId);
        RLock todoRecordLock = redissonClient.getLock(redissonKey);
        todoRecordLock.lock();
        try {
            List<TodoRecordDetail> recordDetailList = recordDetailMapper.toRecordDetailList(recordDTO.recordDetail());
            TodoRecord todoRecord = recordMapper.toRecord(recordDTO);
            todoRecord.setId(new TodoRecordId(userId, todoId));
            todoRecordRepository.save(todoRecord);
            recordDetailList.forEach(recordDetail ->
                    recordDetail.setId(new TodoRecordDetailId(todoId, recordDetail.getId().getRecordId())));
            todoRecordDetailRepository.saveAll(recordDetailList);
        } finally {
            todoRecordLock.unlock();
        }

    }
}
