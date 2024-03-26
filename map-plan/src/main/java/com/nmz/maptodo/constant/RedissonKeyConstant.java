package com.nmz.maptodo.constant;

/**
 * @Description: todo模块的redisson的key模板
 * @Version: 1.0
 * @Author: 聂明智
 * @Date: 2023/11/28-20:56
 */
public class RedissonKeyConstant {

    public static final String PLAN_RECORD_REDISSON_KEY = "map-plan: userId: %d, recordId: %d";
    public static final String TIMEOUT_REDISSON_KEY = "map-plan: timeout-key";

}
