package com.yb.consumer.customrule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 〈功能概述〉<br>
 * 自定义负载均衡策略的接口
 * @author: yb
 * @date: 2020/6/26 0026 14:30
 */
public interface ILoadBalance {

    /**
     * 负载均衡接口
     * @param serviceInstances
     * @return
     */
    ServiceInstance getLoadBalance(List<ServiceInstance> serviceInstances);
}
