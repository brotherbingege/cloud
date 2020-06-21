package com.yb.consumer.controller;

import com.yb.common.CommonResult;
import com.yb.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 〈功能概述〉<br>
 * 消费者对外暴露的服务接口
 * @author: yb
 * @date: 2020/6/21 0021 17:15
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

//    public static final String PAYMENT_BASE_URL = "http://localhost:8001";
    public static final String PAYMENT_BASE_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_BASE_URL+"/pay/payment/get/"+id,CommonResult.class);
    }

    @PostMapping("/add")
    public  CommonResult<Payment> addPayment(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_BASE_URL+"/pay/add",payment,CommonResult.class);
    }


}
