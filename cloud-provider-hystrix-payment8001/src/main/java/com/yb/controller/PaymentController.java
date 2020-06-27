package com.yb.controller;

import com.yb.service.IPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/27 0027 14:52
 */
@RestController
public class PaymentController {

    @Autowired
    IPayment iPayment;

    @GetMapping("/hystrix/ok/{id}")
    public String getOK(@PathVariable("id")Integer id){
        final String ok = iPayment.getOk(id);
        return ok;
    }
    @GetMapping("/hystrix/timeout/{id}")
    public String getTimeOut(@PathVariable("id")Integer id){
        final String ok = iPayment.getTimeOut(id);
        return ok;
    }

    @GetMapping("/hystrix/breaker/{id}")
    public String testHystrixBreaker(@PathVariable("id")Integer id){
        String s = iPayment.paymentCircuitBreaker(id);
        return s;
    }
}
