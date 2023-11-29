package com.nmz.maptodo.controller;

import com.nmz.mapcommon.api.HelloService;
import com.nmz.mapcommon.context.UserIdContext;
import com.nmz.mapcommon.result.Result;
import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-17:48
 */
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
@Slf4j
public class RecordController {

    private final RecordService recordService;
    @DubboReference
    private HelloService helloService;

    @PostMapping("/add")
    public Result<String> addRecord(@RequestBody RecordDTO recordDTO) {
        Long userId = UserIdContext.getUserId();
        recordService.addRecord(recordDTO, userId);
        return Result.success("添加成功");
    }

    @PostMapping("/{todoId}")
    public Result<String> updateRecord(@RequestBody RecordDTO recordDTO, @PathVariable Long todoId) {
        recordService.updateRecord(recordDTO, todoId);
        return Result.success("删除成功");
    }

    @GetMapping("testDubbo")
    public void testDubbo() {
        log.info(helloService.syHello("todoRecord"));
    }

}
