package com.nmz.mapcommon.context;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/28-19:21
 */
public class UserIdContext {
    private static ThreadLocal<Long> userId = new ThreadLocal<>();

    public static Long getUserId() {
        return userId.get();
    }

    public static void setUserId(Long id) {
        userId.set(id);
    }

    public static void remove(){
        userId.remove();
    }

}
