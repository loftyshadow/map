package com.nmz.maptodo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;


@Configuration
public class RedissonConfig {

    private static final String ADDRESS_PREFIX = "redis://";
    Logger log = LoggerFactory.getLogger(RedissonConfig.class);
    // 直接使用starter注入的redis配置信息
    @Autowired
    private RedisProperties redisProperties;
    private int timeout = 3000;
    private final int connectionPoolSize = 64;
    private final int connectionMinimumIdleSize = 10;
    private final int pingConnectionInterval = 60000;

    /**
     * 单机模式
     */
    @Bean
    public RedissonClient initBean() {

        // 单机模式
        String host = redisProperties.getHost();
        if (StringUtils.hasLength(host)) {
            log.info("redis is single mode");
            return redissonSingle();
        }

        log.error("redisson config can not support this redis mode");
        return null;
    }

    /**
     * 单机模式
     */
    private RedissonClient redissonSingle() {
        String host = redisProperties.getHost();
        String password = redisProperties.getPassword();
        int port = redisProperties.getPort();
        // 设置超时时间
        if (!redisProperties.getTimeout().isZero()) {
            timeout = redisProperties.getTimeout().getNano();
        }
        // 声明一个配置类
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(ADDRESS_PREFIX + host + ":" + port)
                .setTimeout(timeout)
                .setPingConnectionInterval(pingConnectionInterval)
                .setConnectionPoolSize(this.connectionPoolSize)
                .setConnectionMinimumIdleSize(this.connectionMinimumIdleSize);
        // 判断密码
        if (StringUtils.hasLength(password)) {
            serverConfig.setPassword(password);
        }
        return Redisson.create(config);
    }

}