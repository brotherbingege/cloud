package com.yb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/6 0006 16:51
 */
@Configuration
public class TemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getTemplate()
    {
        return new RestTemplate();
    }
}
