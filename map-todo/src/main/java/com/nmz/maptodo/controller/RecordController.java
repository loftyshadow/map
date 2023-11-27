package com.nmz.maptodo.controller;

import com.nmz.mapcommon.result.Result;
import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.service.RecordService;
import lombok.RequiredArgsConstructor;
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
public class RecordController {

    private final RecordService recordService;

    @PostMapping("/add")
    public Result<String> addRecord(@RequestBody RecordDTO recordDTO) {
        recordService.addRecord(recordDTO);
        return Result.success("添加成功");
    }

}
