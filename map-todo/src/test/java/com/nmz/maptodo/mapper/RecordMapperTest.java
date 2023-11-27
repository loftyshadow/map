package com.nmz.maptodo.mapper;

import com.nmz.maptodo.dto.RecordDetailDTO;
import com.nmz.maptodo.entity.TodoRecordDetail;
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

    @Autowired
    RecordDetailMapper underTest;

    @Test
    void test() {
        RecordDetailDTO recordDetailDTO = new RecordDetailDTO("测试", false, false);
        TodoRecordDetail todoRecordDetail = underTest.toRecordDetail(recordDetailDTO);
        System.out.println(todoRecordDetail);
    }


}