package com.yb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *  动态刷新需要的步骤：
 *  1.POM引入 actuator监控模块
 *  2.暴露监控模块的端点yml配置
 *     #暴露监控端点
 * management:
 *   endpoints:
 *     web:
 *       exposure:
 *         include: "*"
 *3.添加刷新注解@RefreshScope
 *4.手动刷新访问 POST http://localhost:3355/actuator/refresh
 * @author: yb
 * @date: 2020/6/28 0028 23:18
 */
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
@RestController
public class TestController
{
    @Value("${test}")
    private String value;

    @GetMapping("/test")
    private String test(){
        return value;
    }

}
