package com.nmz.maptodo.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class RabbitMQCallback implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {


    //注入
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQCallback(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    /*
        1.发消息 交换机接收到了 回调
        * correlationData保存回调消息的id及相关信息
        * 交换机收到消息 ack = true;
           cause null
           2.发消息 交换机接受失败了 回调
           correlationData保存回调消息的id及相关信息
           交换机收到消息 ack = false
           cause  失败的原因
        * */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id = correlationData != null ? correlationData.getId() : "";
        if (ack) {
            log.info("交换机收到了消息，id为：{}的消息", id);
        } else {
            log.info("交换机未收到id为：{}的消息,由于原因{}", id, cause);
        }
    }


    //可以在消息传递过程中不可达目的地时将消息返回给生产者，只有不可达目的地的时候才进行回退
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.info("消息{},被交换机{}退回,退回原因{},路由key{}", new String(returned.getMessage().getBody()), returned.getExchange(), returned.getReplyText(), returned.getRoutingKey());
    }
}
