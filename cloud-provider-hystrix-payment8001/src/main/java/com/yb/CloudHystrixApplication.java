package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/27 0027 14:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启
public class CloudHystrixApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(CloudHystrixApplication.class,args);
    }
}
