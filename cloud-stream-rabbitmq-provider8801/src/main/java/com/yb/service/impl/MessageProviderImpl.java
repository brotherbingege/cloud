package com.yb.service.impl;

import com.yb.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/2 0002 22:04
 */
//#开启绑定，指定是消息的发送端，及output
@EnableBinding(Source.class)  //定义消息发送管道
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*************发送的流水号："+serial);
        return "*************发送的流水号："+serial;
    }
}
