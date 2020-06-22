package com.yb.controller;

import com.yb.common.CommonResult;
import com.yb.entities.Payment;
import com.yb.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/5/16 0:08
 */
@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @GetMapping("/payment/zk")
    public String getById(){
        return "hello+zookeeper--"+ UUID.randomUUID().toString();
    }

}
