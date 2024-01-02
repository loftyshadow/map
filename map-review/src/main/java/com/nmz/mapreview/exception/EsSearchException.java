package com.nmz.mapreview.exception;

import com.nmz.mapcommon.exception.BaseException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2024/1/1-23:38
 */
public class EsSearchException extends BaseException {
    public static final EsSearchException SEARCH_FAILED = new EsSearchException(BAD_REQUEST.value(), "查找失败");
    public static final EsSearchException SERIALIZATION_FAILED = new EsSearchException(BAD_REQUEST.value(), "序列化失败");


    private final int code;
    private final String message;


    public EsSearchException(int code, String message) {
        super(code, message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
