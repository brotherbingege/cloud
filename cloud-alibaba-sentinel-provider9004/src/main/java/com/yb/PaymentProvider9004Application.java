package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/6 0006 16:40
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PaymentProvider9004Application {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProvider9004Application.class,args);
    }
}
