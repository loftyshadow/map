package com.nmz.maptodo.exception;

import com.nmz.mapcommon.exception.BaseException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 3/26/2024-7:47 PM
 */
public class PlanException extends BaseException {
    public static final PlanException PLAN_NOT_EXIST_EXCEPTION = new PlanException(BAD_REQUEST.value(), "行程记录不存在");
    private final int code;
    private final String message;

    public PlanException(int code, String message) {
        super(code, message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
