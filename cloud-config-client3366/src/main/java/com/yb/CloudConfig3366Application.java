package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/30 0030 22:20
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfig3366Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig3366Application.class,args);
    }
}
