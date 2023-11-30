package com.nmz.maptodo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQQueueConfig {

    //普通交换机名称
    public static final String NORMAL_EXCHANGE = "normal_exchange";

    //死信交换机名称
    public static final String DEAD_EXCHANGE = "dead_exchange";

    //普通队列名称
    public static final String NORMAL_QUEUE = "normal_queue";

    //普通队列名称
    public static final String NORMAL_QUEUE2 = "normal_queue2";

    //死信队列名称
    public static final String DEAD_QUEUE = "dead_queue";

    //通用队列名称
    public static final String COMMON_QUEUE = "common_queue";

    //声明普通交换机
    @Bean("normalExchange")
    public DirectExchange normalExchange(){

        return new DirectExchange(NORMAL_EXCHANGE);

    }

    //声明死信交换机
    @Bean("deadExchange")
    public DirectExchange deadExchange(){

        return new DirectExchange(DEAD_EXCHANGE);

    }

    //声明普通队列
    @Bean("normalQueue")
    public Queue normalQueue(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        //设置死信routingkey
        args.put("x-dead-letter-routing-key", "dead");
        //过期时间(单位为毫秒)(生产者也可以设置过期时间)
        args.put("x-message-ttl", 10000);
        return QueueBuilder.durable(NORMAL_QUEUE).withArguments(args).build();
    }

    //声明普通队列
    @Bean("normalQueue2")
    public Queue normalQueue2(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        //设置死信routingkey
        args.put("x-dead-letter-routing-key", "dead");
        //过期时间(单位为毫秒)(生产者也可以设置过期时间)
        args.put("x-message-ttl", 40000);
        return QueueBuilder.durable(NORMAL_QUEUE2).withArguments(args).build();
    }
    //声明普通队列
    @Bean("commonQueue")
    public Queue commonQueue(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        //设置死信routingkey
        args.put("x-dead-letter-routing-key", "dead");
        //过期时间(单位为毫秒)(此处为通用队列即生产者设置过期时间)
//        args.put("x-message-ttl", 40000);
        return QueueBuilder.durable(COMMON_QUEUE).withArguments(args).build();
    }

    //声明死信队列
    @Bean("deadQueue")
    public Queue deadQueue(){
        return QueueBuilder.durable(DEAD_QUEUE).build();
    }

    //绑定
    @Bean
    public Binding normalQueueBind(@Qualifier("normalQueue")Queue normalQueue,@Qualifier("normalExchange") DirectExchange normalExchange){
        return BindingBuilder.bind(normalQueue).to(normalExchange).with("normal");
    }

    @Bean
    public Binding commonQueueBind(@Qualifier("commonQueue")Queue normalQueue,@Qualifier("normalExchange") DirectExchange normalExchange){
        return BindingBuilder.bind(normalQueue).to(normalExchange).with("common");
    }

    @Bean
    public Binding normalQueue2Bind(@Qualifier("normalQueue2")Queue normalQueue,@Qualifier("normalExchange") DirectExchange normalExchange){
        return BindingBuilder.bind(normalQueue).to(normalExchange).with("normal2");
    }

    @Bean
    public Binding deadQueueBind(@Qualifier("deadQueue")Queue normalQueue,@Qualifier("deadExchange") DirectExchange normalExchange){
        return BindingBuilder.bind(normalQueue).to(normalExchange).with("dead");
    }
}
