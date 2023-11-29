package com.nmz.mapauthserver.service.impl;

import com.nmz.mapcommon.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloServiceImpl implements HelloService {

    public String syHello(String name) {
        return "hello "+name;
    }
}