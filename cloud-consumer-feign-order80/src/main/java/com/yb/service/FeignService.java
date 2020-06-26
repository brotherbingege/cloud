package com.yb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/26 0026 16:36
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignService {

    @GetMapping("/pay/test/lb")
    String testFeignLB();

    @GetMapping("/pay/test/openfeign/timeout")
    String testOpenFeignTimeOut();
}
