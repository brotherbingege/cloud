package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/21 0021 22:05
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001Application {
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaServer7001Application.class,args);
    }
}
