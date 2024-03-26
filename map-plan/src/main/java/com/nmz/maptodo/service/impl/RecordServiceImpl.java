package com.nmz.maptodo.service.impl;

import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.entity.PlanRecordDetail;
import com.nmz.maptodo.entity.PlanRecord;
import com.nmz.maptodo.entity.PlanRecordDetailId;
import com.nmz.maptodo.entity.PlanRecordId;
import com.nmz.maptodo.mapper.RecordDetailMapper;
import com.nmz.maptodo.mapper.RecordMapper;
import com.nmz.maptodo.mapper.PlanRecordDetailRepository;
import com.nmz.maptodo.mapper.PlanRecordRepository;
import com.nmz.maptodo.service.RecordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nmz.maptodo.constant.RedissonKeyConstant.PLAN_RECORD_REDISSON_KEY;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-17:50
 */
@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final PlanRecordRepository todoRecordRepository;
    private final PlanRecordDetailRepository todoRecordDetailRepository;
    private final RecordMapper recordMapper;
    private final RecordDetailMapper recordDetailMapper;
    private final RedissonClient redissonClient;

    @Override
    @Transactional
    public Long addRecord(RecordDTO recordDTO, Long userId) {
        List<PlanRecordDetail> recordDetailList = recordDetailMapper.toRecordDetailList(recordDTO.recordDetail());
        PlanRecord planRecord = recordMapper.toRecord(recordDTO);
        planRecord.setId(new PlanRecordId(userId, null));
        PlanRecord record = todoRecordRepository.save(planRecord);
        Long recordId = record.getId().getRecordId();
        recordDetailList.forEach(recordDetail ->
                recordDetail.setId(new PlanRecordDetailId(recordId)));
        todoRecordDetailRepository.saveAll(recordDetailList);
        return recordId;
    }

    @Override
    @Transactional
    public void updateRecord(RecordDTO recordDTO, Long todoId) {
        Long userId = recordDTO.userId();
        // 加锁
        String redissonKey = PLAN_RECORD_REDISSON_KEY.formatted(userId, todoId);
        RLock todoRecordLock = redissonClient.getLock(redissonKey);
        todoRecordLock.lock();
        try {
            List<PlanRecordDetail> recordDetailList = recordDetailMapper.toRecordDetailList(recordDTO.recordDetail());
            PlanRecord planRecord = recordMapper.toRecord(recordDTO);
            planRecord.setId(new PlanRecordId(userId, todoId));
            todoRecordRepository.save(planRecord);
            recordDetailList.forEach(recordDetail ->
                    recordDetail.setId(new PlanRecordDetailId(todoId, recordDetail.getId().getRecordId())));
            todoRecordDetailRepository.saveAll(recordDetailList);
        } finally {
            todoRecordLock.unlock();
        }

    }
}
