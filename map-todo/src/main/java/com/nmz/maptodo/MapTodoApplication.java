package com.nmz.maptodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MapTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapTodoApplication.class, args);
    }

}
