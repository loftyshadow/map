package com.nmz.mapauthserver;

import com.nmz.mapauthserver.utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;

@Slf4j
@SpringBootTest
class MapAuthServerApplicationTests {

    @Autowired
    private ValueOperations<String, Object> valueOperations;


    @Test
    void redisTest() {
        valueOperations.set("test", "test");
    }

    @Test
    void md5Test() {
        log.info(SecurityUtil.md5("admin"));
    }


}
