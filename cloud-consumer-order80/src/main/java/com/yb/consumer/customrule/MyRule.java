package com.yb.consumer.customrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/26 0026 14:08
 */
@Component
public class MyRule implements ILoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getNext(){
        int next;
        int curr;
        do{
            curr = atomicInteger.get();
            next = curr > Integer.MAX_VALUE ? 0 : curr+1;
        }while(!atomicInteger.compareAndSet(curr,next));

        return next;
    }
    @Override
    public ServiceInstance getLoadBalance(List<ServiceInstance> serviceInstances) {
        int index = getNext() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
