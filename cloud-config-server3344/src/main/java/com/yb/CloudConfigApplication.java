package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/28 0028 23:00
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigApplication.class,args);
    }
}
