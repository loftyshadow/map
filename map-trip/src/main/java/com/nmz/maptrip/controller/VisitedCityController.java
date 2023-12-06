package com.nmz.maptrip.controller;

import com.nmz.mapcommon.result.Result;
import com.nmz.maptrip.entity.VisitedCity;
import com.nmz.maptrip.service.VisitedCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/6-18:02
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/visitedCity")
public class VisitedCityController {

    private final VisitedCityService visitedCityService;

    @PostMapping("/add")
    public Result<String> addVisitedCity(@RequestBody VisitedCity visitedCity) {
        visitedCityService.addVisitedCity(visitedCity);
        return Result.success("添加成功");
    }

}
