package com.chuixue.springcloud.controller;

import com.chuixue.springcloud.domain.CommonResult;
import com.chuixue.springcloud.domain.Order;
import com.chuixue.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 丁鹏
 * @version $ Id: OrderController, v 0.1 2022/04/18 22:55 peng.ding Exp $
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
