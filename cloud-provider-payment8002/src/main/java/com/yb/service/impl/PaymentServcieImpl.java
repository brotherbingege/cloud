package com.yb.service.impl;

import com.yb.dao.PaymentDao;
import com.yb.entities.Payment;
import com.yb.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/5/16 0:02
 */
@Service
public class PaymentServcieImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
