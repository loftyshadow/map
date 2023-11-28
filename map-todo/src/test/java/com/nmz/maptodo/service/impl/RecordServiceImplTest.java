package com.nmz.maptodo.service.impl;

import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.dto.RecordDetailDTO;
import com.nmz.maptodo.service.RecordService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/27-11:19
 */
@SpringBootTest
class RecordServiceImplTest {

    @Autowired
    RecordService recordService;

    @Test
    @Transactional
    void addRecord() {
        // given
        List<RecordDetailDTO> recordDetailDTOList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            RecordDetailDTO recordDetailDTO = new RecordDetailDTO("测试" + i, false, false);
            recordDetailDTOList.add(recordDetailDTO);
        }
        RecordDTO recordDTO = new RecordDTO(null, null, "测试", false, false, recordDetailDTOList);

        // when
        recordService.addRecord(recordDTO, null);


    }
}