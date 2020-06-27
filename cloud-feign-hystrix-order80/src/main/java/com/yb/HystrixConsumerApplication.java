package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/27 0027 16:14
 */
@SpringBootApplication
@EnableFeignClients //开启Feign
@EnableHystrix //开启Hystrix
public class HystrixConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumerApplication.class,args);
    }
}
