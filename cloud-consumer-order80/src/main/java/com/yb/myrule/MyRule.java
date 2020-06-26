package com.yb.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈功能概述〉<br>
 * 自定义ribbon负载均衡规则
 * 注意：此配置不能被@ComponeScan扫描到，否则会被所有的Ribbon客户端所共享，达不到特殊定制话的目的
 * 使用在启动类上面加上 @RibbonClient(name = "服务名称", configuration=MyRule.class)
 * @author: yb
 * @date: 2020/6/25 0025 10:43
 */
@Configuration
public class MyRule {

    @Bean
    public IRule getMyRule(){
        //随机
        return new RandomRule();
    }

}
