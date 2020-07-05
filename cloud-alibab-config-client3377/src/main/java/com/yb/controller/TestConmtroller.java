package com.yb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/4 0004 01:00
 */
@RestController
@RefreshScope  //开始自动刷新配置
public class TestConmtroller {

    @Value("${config.info}")
    private String info;

    @GetMapping("/hw")
    public String getInfo(){
        return info;
    }
}
