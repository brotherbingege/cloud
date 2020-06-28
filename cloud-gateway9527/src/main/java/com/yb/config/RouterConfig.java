package com.yb.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈功能概述〉<br>
 * gateway 编码配置路由
 * @author: yb
 * @date: 2020/6/28 0028 21:09
 */
@Configuration
public class RouterConfig {

    /**
     * 代码配置路由
     *
     * 访问: localhost:9527/mil   --->跳转到http://news.baidu.com/mil
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        //配置中的路由
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        //http://news.baidu.com/mil
        routes.route("route_id",r->r.path("/mil").uri("http://news.baidu.com/mil")).build();
        return routes.build();
    }
}
