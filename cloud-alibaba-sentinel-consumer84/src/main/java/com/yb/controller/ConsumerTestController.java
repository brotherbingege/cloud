package com.yb.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yb.common.CommonResult;
import com.yb.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/6 0006 16:56
 */
@RestController
public class ConsumerTestController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    RestTemplate restTemplate;

    /**
     * fallback 是管Java运行时异常
     * blockHandler 只管限流异常
     * @param id
     * @return
     */
    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")//只配置了个资源名称的value,没配置其他
//    @SentinelResource(value = "fallback",fallback = "blockFallback")//只配置fallback和value
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")//只配置blockHandler和value
//    @SentinelResource(value = "fallback",fallback = "blockFallback",blockHandler = "blockHandler")//配置blockHandler、fallback和value,限流异常优先级高于Java异常
    @SentinelResource(value = "fallback",fallback = "blockFallback",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})//ignore
    public CommonResult<Payment> fallback(@PathVariable("id") Long id)
    {
        CommonResult forObject = restTemplate.getForObject(SERVICE_URL + "/payment/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (forObject == null) {
            throw new NullPointerException("ID 没有记录。空指针异常");
        }
        return forObject;

    }
    //fallback
    public CommonResult<Payment> blockFallback(@PathVariable("id")Long id,Throwable e){
        Payment p = new Payment(id,"null");
        return new CommonResult<>(444,"fallBack===="+e.getMessage());
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id")Long id,BlockException e){
        Payment p = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler===="+e.getMessage());
    }

}
