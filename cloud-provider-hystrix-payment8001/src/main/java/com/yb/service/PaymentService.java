package com.yb.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 〈功能概述〉<br>
 * 服务降级的配置
 * 1.单个降级配置
 *       @HystrixCommand(fallbackMethod = "getTimeOutFallBack",commandProperties = {
 *            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
 *       })
 * 2.全局配置
 *    @DefaultProperties(defaultFallback = "globalFallBack")
 *    @HystrixCommand
 *
 * @author: yb
 * @date: 2020/6/27 0027 14:52
 */
@Service
//@DefaultProperties(defaultFallback = "globalFallBack")
public class PaymentService implements IPayment{

    @Override
    public String getOk(int id) {
        return "current thread =>"+Thread.currentThread().getName()+" ok";
    }

//    @HystrixCommand(fallbackMethod = "getTimeOutFallBack",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
//    })
    //@HystrixCommand
    @Override
    public String getTimeOut(int id) {
        int sleepSecond = 5;
        try {
            TimeUnit.SECONDS.sleep(sleepSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "current thread =>"+Thread.currentThread().getName()+" time out";
    }

    public String getTimeOutFallBack(int id){
        return "current thread =>"+Thread.currentThread().getName()+" getTimeOutFallBack 服务器繁忙，调用失败啦";
    }

    public String globalFallBack(){
        return "Global fallback ====";
    }



    //===============服务熔断
    //其他属性参照  HystrixCommandProperties类
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallBack",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少跳闸
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if(id < 0){
            throw new RuntimeException("-------id 不能为空");
        }
        String idStr = UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+idStr;
    }

    public String paymentCircuitBreaker_fallBack(@PathVariable("id")Integer id){
        return "id 不能为负数 ，请稍微再试！！！"+id;
    }
}
