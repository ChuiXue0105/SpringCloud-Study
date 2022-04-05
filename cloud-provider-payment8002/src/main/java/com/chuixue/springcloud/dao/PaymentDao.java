package com.chuixue.springcloud.dao;

import com.chuixue.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 丁鹏
 * @version $ Id: PaymentDao, v 0.1 2022/04/04 15:48 peng.ding Exp $
 */
@Mapper
public interface PaymentDao {

    int add(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
