package com.yb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈功能概述〉<br>
 * 支付服务启动类
 * @author: yb
 * @date: 2020/5/15 22:48
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudProviderPayment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8002Application.class,args);
    }
}
