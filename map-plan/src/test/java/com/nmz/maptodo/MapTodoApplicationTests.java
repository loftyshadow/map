package com.nmz.maptodo;
import com.nmz.maptodo.entity.PlanRecordDetail;
import com.nmz.maptodo.entity.PlanRecordDetailId;

import com.nmz.maptodo.mapper.PlanRecordDetailRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapTodoApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(MapTodoApplicationTests.class);

    @Autowired
    PlanRecordDetailRepository todoRecordDetailRepository;

    @Test
    void contextLoads() {
        PlanRecordDetail entity = new PlanRecordDetail();
        PlanRecordDetailId id = new PlanRecordDetailId();
        id.setRecordId(1L);
        entity.setId(id);
        entity.setDetailChecked(false);
        entity.setDetailIsDelete(false);
        entity.setDetailText("测试");

        todoRecordDetailRepository.save(entity);
    }


    @Test
    void getDetailById() {
        log.debug("todoRecordDetailRepository.findByIdRecordId(1L)为: {}",
                todoRecordDetailRepository.getToDoRecordDetailByRecordId(1L));
    }



}
