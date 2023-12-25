package com.nmz.mapscenicspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.nmz.mapcommon.entity"})
public class MapScenicSpotApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapScenicSpotApplication.class, args);
    }

}
