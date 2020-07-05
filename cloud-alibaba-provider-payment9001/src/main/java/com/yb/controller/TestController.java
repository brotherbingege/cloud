package com.yb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/3 0003 23:59
 */
@RestController
@Slf4j
//@RefreshScope  //开启自动刷新
public class TestController {

//    @Value("${config.info}")
//    private String info;
//
//    @GetMapping("/nacos/config/info")
//    public String get(){
//        return info;
//    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/hw")
    public String helloword(){
        return "haha Nacos i can do it =  port=>" +port;
    }
}
