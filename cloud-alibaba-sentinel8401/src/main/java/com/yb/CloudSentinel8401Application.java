package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/5 0005 19:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudSentinel8401Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudSentinel8401Application.class,args);
    }
}
