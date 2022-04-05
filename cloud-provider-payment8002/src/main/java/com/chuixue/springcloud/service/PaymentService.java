package com.chuixue.springcloud.service;

import com.chuixue.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 丁鹏
 * @version $ Id: PaymentService, v 0.1 2022/04/04 16:00 peng.ding Exp $
 */
public interface PaymentService {

    int add(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
