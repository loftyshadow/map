package com.nmz.maptodo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDubbo
@ComponentScan({"com.nmz.mapcommon.filter"})
@EnableJpaAuditing
public class MapTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapTodoApplication.class, args);
    }

}
