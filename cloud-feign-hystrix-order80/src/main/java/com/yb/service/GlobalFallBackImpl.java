package com.yb.service;

import org.springframework.stereotype.Component;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/27 0027 18:00
 */
@Component
public class GlobalFallBackImpl implements PaymentService {

    @Override
    public String getOK(Integer id) {
        return "ok - error";
    }

    @Override
    public String getTimeOut(Integer id) {
        return "time out error";
    }
}
