package com.nmz.maptodo.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.nmz.maptodo.dto.RecordDetailDTO;
import com.nmz.maptodo.entity.TodoRecordDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/25-20:45
 */
@SpringBootTest
class RecordMapperTestTest {

    @Autowired
    RecordMapper underTest;

    @Test
    void test() {
        TodoRecordDetail todoRecordDetail = new TodoRecordDetail();
        todoRecordDetail.setDetailChecked(true);
        todoRecordDetail.setDetailIsDelete(true);
        todoRecordDetail.setDetailText("test123");
        todoRecordDetail.setDetailCreateTime(new Date());
        todoRecordDetail.setDetailUpdateTime(new Date());
        RecordDetailDTO recordDetailDTO = underTest.toRecordDetail(todoRecordDetail);
        System.out.println(recordDetailDTO);
    }


}