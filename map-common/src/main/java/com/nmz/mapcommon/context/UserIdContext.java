package com.nmz.mapcommon.context;

import com.nmz.mapcommon.utils.ThreadLocalUtils;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/28-19:21
 */
public class UserIdContext {

    private static final String USER_ID = "userId";

    public static Long getUserId() {
        return ThreadLocalUtils.get(USER_ID);
    }

    public static void setUserId(Long userId) {
        ThreadLocalUtils.set(USER_ID, userId);
    }

    public static void remove(){
        ThreadLocalUtils.removeKey(USER_ID);
    }

}
