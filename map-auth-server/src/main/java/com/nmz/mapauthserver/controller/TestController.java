package com.nmz.mapauthserver.controller;

import com.nmz.mapcommon.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Description: 测试接口
 * @Author: 聂明智
 * @Date: 2023/9/21-17:29
 */
@RestController
public class TestController {

    @GetMapping("auth/api/test/time")
    public Result<String> test(){
        return Result.success(LocalDateTime.now().toString());
    }

}
