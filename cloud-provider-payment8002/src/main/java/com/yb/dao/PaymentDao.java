package com.yb.dao;

import com.yb.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/5/15 23:49
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
