package com.yb.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 〈功能概述〉<br>
 * 配置类
 * @author: yb
 * @date: 2020/6/21 0021 17:14
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //赋予restTemplate 复杂均衡能力   //测试自定义的负载均衡的时候需要注释掉
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
