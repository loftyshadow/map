package com.nmz.mapcommon.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayedQueueConfig {

    // 队列
    public static final String DELAYED_QUEUE_NAME = "delayed_queue";

    // 交换机
    public static final String DELAYED_EXCHANGE_NAME = "DELAYED_EXCHANGE";

    // 交换机
    public static final String DELAYED_ROUTING_KEY = "delayed";

    // 声明延迟队列
    @Bean
    public Queue delayedQueue() {
        return new Queue(DELAYED_QUEUE_NAME);
    }

    // 声明延迟交换机
    @Bean
    public CustomExchange delayedExchange() {
        Map<String, Object> arguments = new HashMap<>(3);
        // 设置延迟类型
        arguments.put("x-delayed-type", "direct");
        /**
         * 声明自定义交换机
         * 第一个参数：交换机的名称
         * 第二个参数：交换机的类型
         * 第三个参数：是否需要持久化
         * 第四个参数：是否自动删除
         * 第五个参数：其他参数
         */
        return new CustomExchange(DELAYED_QUEUE_NAME, "x-delayed-message", true, false, arguments);
    }

    // 绑定队列和延迟交换机
    @Bean
    public Binding delayedQueueBindingDelayedExchange(@Qualifier("delayedQueue") Queue delayedQueue,
                                                      @Qualifier("delayedExchange") Exchange delayedExchange) {
        return BindingBuilder.bind(delayedQueue).to(delayedExchange).with(DELAYED_ROUTING_KEY).noargs();
    }

}