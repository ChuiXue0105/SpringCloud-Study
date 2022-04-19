package com.chuixue.springcloud.service.impl;

import com.chuixue.springcloud.entities.CommonResult;
import com.chuixue.springcloud.entities.Payment;
import com.chuixue.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author 丁鹏
 * @version $ Id: PaymentFallbackService, v 0.1 2022/04/17 16:30 peng.ding Exp $
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回，---PaymentFallbackService", new Payment(id, "error"));
    }
}
