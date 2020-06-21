package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/21 0021 23:10
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7002Application {
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaServer7002Application.class,args);
    }
}
