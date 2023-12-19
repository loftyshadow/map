package com.nmz.maptodo;
import com.nmz.maptodo.entity.TodoRecordDetailId;

import com.nmz.maptodo.entity.TodoRecordDetail;
import com.nmz.maptodo.mapper.TodoRecordDetailRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapTodoApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(MapTodoApplicationTests.class);

    @Autowired
    TodoRecordDetailRepository todoRecordDetailRepository;

    @Test
    void contextLoads() {
        TodoRecordDetail entity = new TodoRecordDetail();
        TodoRecordDetailId id = new TodoRecordDetailId();
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
