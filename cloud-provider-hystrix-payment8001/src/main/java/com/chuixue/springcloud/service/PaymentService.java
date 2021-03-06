package com.chuixue.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 丁鹏
 * @version $ Id: PaymentService, v 0.1 2022/04/07 22:33 peng.ding Exp $
 */
public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
