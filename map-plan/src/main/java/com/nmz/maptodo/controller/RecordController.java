package com.nmz.maptodo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nmz.mapcommon.api.HelloService;
import com.nmz.mapcommon.config.DelayedQueueConfig;
import com.nmz.mapcommon.context.UserIdContext;
import com.nmz.mapcommon.result.Result;
import com.nmz.mapcommon.utils.DateUtils;
import com.nmz.mapcommon.utils.JacksonUtils;
import com.nmz.maptodo.dto.RecordDTO;
import com.nmz.maptodo.service.RecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

import static com.nmz.maptodo.constant.RedissonKeyConstant.PLAN_RECORD_REDISSON_KEY;
import static com.nmz.maptodo.constant.RedissonKeyConstant.TIMEOUT_REDISSON_KEY;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-17:48
 */
@Slf4j
@RestController
@RequestMapping("/todo")
@Tag(name = "RecordController", description = "待办事项RecordController")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;
    private final RabbitTemplate rabbitTemplate;
    private final ZSetOperations<String, Long> zSetOperations;

    @DubboReference
    private HelloService helloService;

    @PostMapping("/add")
    public Result<String> addRecord(@RequestBody RecordDTO recordDTO) throws JsonProcessingException {
        Long userId = UserIdContext.getUserId();
        Integer delayTime = recordDTO.planDelay();
        Long recordId = recordService.addRecord(recordDTO, userId);
        // 将订单号及超时时间添加到zset中
        zSetOperations.add(TIMEOUT_REDISSON_KEY, recordId, DateUtils.getTimeStamp() + delayTime);
        return Result.success("添加成功");
    }

    // 发送MQ实现行程
    private void sendToMQQueue(RecordDTO recordDTO) {
        Integer delayTime = recordDTO.planDelay();
        String message = JacksonUtils.obj2json(recordDTO);
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_QUEUE_NAME, DelayedQueueConfig.DELAYED_ROUTING_KEY, message, msg -> {
            // 发送消息的时候延迟时长
            msg.getMessageProperties().setDelay(delayTime);
            return msg;
        });
    }

    @PostMapping("/{planId}")
    public Result<String> updateRecord(@RequestBody RecordDTO recordDTO, @PathVariable Long planId) {
        recordService.updateRecord(recordDTO, planId);
        return Result.success("删除成功");
    }

    @GetMapping("testDubbo")
    public void testDubbo() {
        log.info(helloService.syHello("todoRecord"));
    }

}
