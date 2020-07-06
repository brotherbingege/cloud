package com.yb.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/6 0006 20:53
 */
@FeignClient(value = "nacos-payment-provider")
public interface PaymentService {

}
