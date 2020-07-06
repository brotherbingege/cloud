package com.yb.controller;

import com.yb.common.CommonResult;
import com.yb.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/6 0006 16:41
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    public static HashMap<Long, Payment> data = new HashMap<>();
    static{
        data.put(1L,new Payment(1L,"uuid1"));
        data.put(2L,new Payment(2L,"uuid2"));
        data.put(3L,new Payment(3L,"uuid3"));
    }

    @GetMapping("payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id")Long id){
        Payment payment = data.get(id);
        return new CommonResult(200,"server port =>"+port,payment);
    }

}
