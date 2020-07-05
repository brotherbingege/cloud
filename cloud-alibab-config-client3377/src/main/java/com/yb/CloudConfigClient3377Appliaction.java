package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/4 0004 00:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConfigClient3377Appliaction {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3377Appliaction.class,args);
    }
}
