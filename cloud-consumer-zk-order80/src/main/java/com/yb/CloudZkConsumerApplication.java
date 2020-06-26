package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/23 0023 22:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudZkConsumerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CloudZkConsumerApplication.class,args);
    }
}
