package com.nmz.maptodo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Slf4j
@RestController
@RequestMapping("/ttl")
//发送延迟消息
public class SendMsgController {


    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }


    @RequestMapping("/sendMsg/{message}")
    public void sendMsg(@PathVariable String message){
        log.info("当前时间:{},发送一条消息给两个TTL队列{}",new Date(), message);
        rabbitTemplate.convertAndSend("normal_exchange", "normal","消息来自ttl为10队列" + message);
        rabbitTemplate.convertAndSend("normal_exchange", "normal2","消息来自ttl为40队列"+ message);
    }



    //发送过期时间msg(重载方法)
    @RequestMapping("/sendTTLMsg/{message}/{ttl}")
    public void sendMsg(@PathVariable("message") String message, @PathVariable("ttl") String ttl){
        log.info("当前时间:{},发送一条时长为{}ms的延迟消息给common队列{}",new Date(), ttl, message );
        MessagePostProcessor messagePostProcessor = (msg) -> {
            msg.getMessageProperties().setExpiration(ttl);
            return msg;
        };
        rabbitTemplate.convertAndSend("normal_exchange", "common","消息来自ttl为40队列"+ message, messagePostProcessor);
    }


}
