package com.yb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/4 0004 00:30
 */
@RestController
public class TestController {

    @Value("${server.url.nacos-provider-service}")
    private String serverUrl;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/hw")
    public String hw(){
        return restTemplate.getForObject(serverUrl+"/hw",String.class);
    }

}
