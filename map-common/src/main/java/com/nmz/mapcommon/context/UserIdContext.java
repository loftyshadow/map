package com.nmz.mapcommon.context;

import com.nmz.mapcommon.utils.ThreadLocalUtil;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/28-19:21
 */
public class UserIdContext {

    private static final String USER_ID = "userId";

    public static Long getUserId() {
        return ThreadLocalUtil.get(USER_ID);
    }

    public static void setUserId(Long userId) {
        ThreadLocalUtil.set(USER_ID, userId);
    }

    public static void remove(){
        ThreadLocalUtil.removeKey(USER_ID);
    }

}
