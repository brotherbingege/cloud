package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/26 0026 16:25
 */
@SpringBootApplication
@EnableFeignClients //#开启feign
public class ConsumerFeignApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerFeignApplication.class,args);
    }
}
