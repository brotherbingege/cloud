package com.yb.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yb.common.CommonResult;
import com.yb.entities.Payment;
import com.yb.myhander.CustomerBlockHandle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/7/6 0006 15:55
 */
@RestController
public class SentinelResourceTestController {
    /**
     * 单个的SentinelResource 注解，单个处理blockHandler
     * @return
     */
    @GetMapping("/byResource")
    //关闭服务，则限流规则也会消失（非持久化的临时节点）
    //不配置blockHander则使用默认的限流返回
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "服务不可用");
    }

    /**
     * 全局限流异常统一处理
     * blockHandlerClass 限流异常处理的类
     * blockHandler 限流异常处理的方法名称，如果不配置类，则默认是当前的类
     * @return
     */
    @GetMapping("/resource")
    @SentinelResource(value = "resource",
            blockHandlerClass = CustomerBlockHandle.class,
            blockHandler = "handleException2")
    public CommonResult globalResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }
}
