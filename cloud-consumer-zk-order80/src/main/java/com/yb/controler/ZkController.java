package com.yb.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/23 0023 22:54
 */
@RestController
public class ZkController {
    public static  final String ZK_ERVERR_URL = "http://cloud-provider-payment";

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/consumer/zk")
    public String getZkinfo(){
        return restTemplate.getForObject(ZK_ERVERR_URL+"/payment/zk",String.class);
    }
}
