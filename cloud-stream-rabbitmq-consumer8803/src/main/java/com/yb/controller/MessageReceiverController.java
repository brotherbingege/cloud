package com.yb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/2 0002 22:38
 */
@Component
@EnableBinding(Sink.class)  //#接收端
public class MessageReceiverController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message ){
        System.out.println("消费者8803："+message.getPayload()+"=端口号="+port);
    }
}
