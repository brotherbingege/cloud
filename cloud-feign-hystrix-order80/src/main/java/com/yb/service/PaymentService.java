package com.yb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 〈功能概述〉<br>
 *  openFeign Service 调用服务端的服务
 *
 * @FeignClient(falback属性)： Hystrix 降级fallback
 *
 * @author: yb
 * @date: 2020/6/27 0027 16:17
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = GlobalFallBackImpl.class)
public interface PaymentService {

    @GetMapping("/hystrix/ok/{id}")
    String getOK(@PathVariable("id")Integer id);

    @GetMapping("/hystrix/timeout/{id}")
    String getTimeOut(@PathVariable("id")Integer id);
}
