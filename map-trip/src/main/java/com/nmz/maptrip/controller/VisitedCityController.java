package com.nmz.maptrip.controller;

import com.nmz.mapcommon.context.UserIdContext;
import com.nmz.mapcommon.result.Result;
import com.nmz.maptrip.entity.VisitedCityEntity;
import com.nmz.maptrip.service.VisitedCityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/6-18:02
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/trip")
@Tag(name = "VisitedCityController", description = "用户访问过的城市VisitedCityController")
public class VisitedCityController {

    private final VisitedCityService visitedCityService;

    @Operation( summary = "获取访问过的城市列表",
            description = "获取访问过的城市列表")
    @GetMapping("/list")
    public Result<Object> getVisitedCityList() {
        Long userId = UserIdContext.getUserId();
        return Result.success(visitedCityService.getVisitedCityList(userId));
    }

    @Operation( summary = "添加访问过的城市",
            description = "添加访问过的城市")
    @PostMapping("/add")
    public Result<String> addVisitedCity(@RequestBody VisitedCityEntity visitedCity) {
        visitedCityService.addVisitedCity(visitedCity);
        return Result.success("添加成功");
    }

}
