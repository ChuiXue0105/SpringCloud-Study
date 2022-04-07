package com.chuixue.springcloud.service.impl;

import com.chuixue.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author 丁鹏
 * @version $ Id: PaymentServiceImpl, v 0.1 2022/04/07 22:34 peng.ding Exp $
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_OK, id:  " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5000;
        try {
            Thread.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_OK, id:  " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时(秒): " + timeNumber;
    }
}
