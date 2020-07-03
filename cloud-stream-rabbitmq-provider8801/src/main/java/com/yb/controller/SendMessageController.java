package com.yb.controller;


import com.yb.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/2 0002 22:11
 */
@RestController
@Slf4j
public class SendMessageController {

    @Autowired
    private IMessageProvider provider;

    @GetMapping("/stream/send")
    public String send(){
        return provider.send();
    }
}
