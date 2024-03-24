package com.nmz.maptodo.utils;

import com.nmz.mapcommon.utils.SpringContextUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2/22/2024-5:53 PM
 */
@Component
public class RedisUtils {

    private static final RedisTemplate redisTemplate = SpringContextUtils.getBean(RedisTemplate.class);

    public static void zincrby(String key , Object value , double score){
        //不管有没有该数据，先add一边，如果有该语句不执行，如果没有就创建一条数据。
        //使用add会覆盖原来score
        redisTemplate.opsForZSet().addIfAbsent(key , value , 0);
        //获取原来的score
        Double score1 = redisTemplate.opsForZSet().score(key, value);
        //自增
        redisTemplate.opsForZSet().add(key , value , score1+ score);
    }

    public static Set zrevrange(String key , long start , long end){
        return redisTemplate.opsForZSet().reverseRange(key , start , end);
    }

}
