package com.nmz.mapscenicspot.exception;

import com.nmz.mapcommon.exception.BaseException;
import jakarta.security.auth.message.AuthException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @Description: 城市相关错误
 * @Author: 聂明智
 * @Date: 2023/12/25-11:10
 */
public class CityException extends BaseException {

    public static final CityException CITY_NOT_EXIST_EXCEPTION = new CityException(BAD_REQUEST.value(), "城市不存在");


    private final int code;
    private final String message;


    public CityException(int code, String message) {
        super(code, message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
