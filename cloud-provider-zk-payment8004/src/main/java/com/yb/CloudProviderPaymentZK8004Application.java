package com.yb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈功能概述〉<br>
 * 支付服务启动类
 * @author: yb
 * @date: 2020/5/15 22:48
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zk作为注册中心时注册服务
public class CloudProviderPaymentZK8004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentZK8004Application.class,args);
    }
}
