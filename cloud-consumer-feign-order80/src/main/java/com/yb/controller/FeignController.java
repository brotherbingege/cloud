package com.yb.controller;

import com.yb.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/26 0026 16:35
 */
@RestController
@RequestMapping("/consumer")
public class FeignController {

    @Autowired
    FeignService feignService;

    @GetMapping("/testFeign")
    public String testFeign(){
        return feignService.testFeignLB();
    }

    @GetMapping("/testTimeout")
    public String testTimeOut(){
        return feignService.testOpenFeignTimeOut();
    }

}
