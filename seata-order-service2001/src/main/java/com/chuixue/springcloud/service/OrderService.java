package com.chuixue.springcloud.service;

import com.chuixue.springcloud.domain.Order;
/**
 * @author 丁鹏
 * @version $ Id: OrderService, v 0.1 2022/04/18 22:33 peng.ding Exp $
 */
public interface OrderService {

    //1. 新建订单
    void create(Order order);

}
