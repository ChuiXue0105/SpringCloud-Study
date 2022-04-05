package com.chuixue.springcloud.service.impl;

import com.chuixue.springcloud.dao.PaymentDao;
import com.chuixue.springcloud.entities.Payment;
import com.chuixue.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 丁鹏
 * @version $ Id: PaymentServcieImpl, v 0.1 2022/04/04 16:01 peng.ding Exp $
 */
@Service
public class PaymentServcieImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
