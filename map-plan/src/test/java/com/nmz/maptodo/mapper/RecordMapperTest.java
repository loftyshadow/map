package com.nmz.maptodo.mapper;

import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.entity.PlanRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/25-20:45
 */
@SpringBootTest
class RecordMapperTest {

    @Autowired(required = false)
    RecordMapper underTest;

    @Test
    void test() {
        RecordDTO recordDTO = new RecordDTO(1L, 1L, "测试", false, false, null);
        PlanRecord planRecord = underTest.toRecord(recordDTO);
        System.out.println(planRecord);
    }


}