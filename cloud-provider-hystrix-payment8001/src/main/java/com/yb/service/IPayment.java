package com.yb.service;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/27 0027 14:52
 */
public interface IPayment {

    String getOk(int id);

    String getTimeOut(int id);

    String paymentCircuitBreaker(Integer id);
}
