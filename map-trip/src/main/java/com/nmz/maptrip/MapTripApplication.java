package com.nmz.maptrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.nmz.mapcommon.filter"})
public class MapTripApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapTripApplication.class, args);
    }

}
