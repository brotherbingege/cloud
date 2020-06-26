package com.yb.consumer.controller;

import com.yb.common.CommonResult;
import com.yb.consumer.customrule.MyRule;
import com.yb.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    MyRule myRule;


    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_BASE_URL+"/pay/payment/get/"+id,CommonResult.class);
    }

    @PostMapping("/add")
    public  CommonResult<Payment> addPayment(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_BASE_URL+"/pay/add",payment,CommonResult.class);
    }

    @GetMapping("/get/entity/{id}")
    public CommonResult<Payment> getEntityPayment(@PathVariable("id")Long id){
        final ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_BASE_URL + "/pay/payment/get/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResult<Payment>(444,"异常");
        }
    }

    @GetMapping("/test/lb")
    public String testLB(){
        final List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        final ServiceInstance loadBalance = myRule.getLoadBalance(instances);
        URI uri = loadBalance.getUri();
        String res = restTemplate.getForObject(uri+"/pay/test/lb",String.class);
        return res;
    }


}
