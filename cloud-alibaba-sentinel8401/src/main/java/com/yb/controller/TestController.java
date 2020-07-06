package com.yb.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/5 0005 19:05
 */
@RestController
public class TestController {

    @GetMapping("/testA")
    public String getA(){
        return "----------TsetA ";
    }

    @GetMapping("/testB")
    public String getB(){
        return "----------TsetB ";
    }

    @GetMapping("/hotKey")
    //没有blockHandler属性的话，前台会直接报错
    @SentinelResource(value="hotKey",blockHandler = "delBlockHander")
    public String getHotKey(@RequestParam(value="k1",required = false)String k1,
                            @RequestParam(value="k2",required = false)String k2){
        return "Hot Key k1=>"+k1+" k2="+k2;
    }
    public String delBlockHander(String k1, String k2, BlockException exception){
        return "限流纸处理的方法，返回限流的逻辑";
    }
}
