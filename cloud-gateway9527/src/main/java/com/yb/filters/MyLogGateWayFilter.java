package com.yb.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 〈功能概述〉<br>
 * 自定义gateway filter组件
 * @author: yb
 * @date: 2020/6/28 0028 21:56
 */
@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("**********************全局过滤器*********"+new Date());
        String userName = exchange.getRequest().getQueryParams().getFirst("username");
        if(userName == null){
            System.out.println("******************用户名为空，非法");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    //过滤器的优先级，越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
