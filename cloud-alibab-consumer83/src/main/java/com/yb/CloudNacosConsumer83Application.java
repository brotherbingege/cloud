package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/4 0004 00:26
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudNacosConsumer83Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConsumer83Application.class,args);
    }
}
