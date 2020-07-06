package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/6 0006 16:50
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsumer84Application {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer84Application.class, args);
    }
}
