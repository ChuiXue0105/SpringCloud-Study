package com.chuixue.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 丁鹏
 * @version $ Id: PaymentFallbackService, v 0.1 2022/04/08 21:21 peng.ding Exp $
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "统一fallback处理";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "统一fallback处理";
    }
}
