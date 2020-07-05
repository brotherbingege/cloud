package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/3 0003 23:55
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNocasProvider9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudNocasProvider9001Application.class,args);
    }
}
