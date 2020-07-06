package com.yb.myhander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yb.common.CommonResult;
import com.yb.entities.Payment;

/**
 * 〈功能概述〉<br>
 * 自定义全局限流异常处理器
 *
 * @author: yb
 * @date: 2020/7/6 0006 16:10
 */
public class CustomerBlockHandle {
    public static CommonResult handleException1(BlockException ex) {
        return new CommonResult(444, "客户自定义的 全局 限流异常处理器1", new Payment(220L, "serial0004"));
    }
    public static CommonResult handleException2(BlockException ex) {
        return new CommonResult(444, "客户自定义的 全局 限流异常处理器2", new Payment(220L, "serial0004"));
    }
}
