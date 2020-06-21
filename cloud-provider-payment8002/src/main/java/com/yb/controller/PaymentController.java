package com.yb.controller;

import com.yb.common.CommonResult;
import com.yb.entities.Payment;
import com.yb.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/5/16 0:08
 */
@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("add")
    public CommonResult add(@RequestBody Payment payment){
        final int i = paymentService.create(payment);
        return i > 0 ? new CommonResult(200,"添加成功8002") : new CommonResult(500,"添加失败");
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id")Long id){
        return new CommonResult<Payment>(200,"查询成功8002",paymentService.getPaymentById(id));
    }

}
