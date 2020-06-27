package com.yb.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yb.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/27 0027 16:20
 */
@RestController
//@DefaultProperties(defaultFallback = "globalFallBack")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String getOK(@PathVariable("id")Integer id){
        return paymentService.getOK(id);
    }

//    @HystrixCommand(fallbackMethod = "getTimeOutFallBack",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    //@HystrixCommand  //全局异常使用的是@DefaultProperties,带有属性则不需要
    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String getTimeOut(@PathVariable("id")Integer id){
        return paymentService.getTimeOut(id);
    }

    public String getTimeOutFallBack(Integer id){
        return "current thread =>"+Thread.currentThread().getName()+" getTimeOutFallBack 服务器繁忙，调用失败啦";
    }

    public String globalFallBack(){
        return "global Fallback 全局异常==fallback==》";
    }
}
