package com.nmz.maptodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan({"com.nmz.mapcommon.filter"})
@EnableJpaAuditing
public class MapTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapTodoApplication.class, args);
    }

}
