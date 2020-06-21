package com.yb.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈功能概述〉<br>
 * 消费者的启动类
 * @author: yb
 * @date: 2020/6/21 0021 17:10
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80Application.class,args);
    }
}
