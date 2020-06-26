package com.yb.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈功能概述〉<br>
 * Feign 的日志配置类并开启配置
 * @author: yb
 * @date: 2020/6/26 0026 22:35
 */
@Configuration
public class FeignConfig {

    @Bean
    /**
     * NONE：默认不显示任何日志
     * BASIC: 仅记录请求方法、URL、相应状态码及执行时间
     * HEADERS： 除了BASIC的信息之外，还有请求和相应头信息
     * FULL: 除了HEADERS外，还有请求和相应的正文及元数据信息
     * 开启配置
     */
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
