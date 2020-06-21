package com.yb.service;

import com.yb.entities.Payment;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/5/16 0:01
 */
public interface PaymentService {

    int create(Payment payment);


    Payment getPaymentById(Long id);
}
