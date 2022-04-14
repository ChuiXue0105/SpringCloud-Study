package com.chuixue.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 丁鹏
 * @version $ Id: PaymentNacosController, v 0.1 2022/04/12 15:46 peng.ding Exp $
 */
@RestController
@Slf4j
public class PaymentNacosController {

    @Value("${server.port}")
    private String serverPost;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort: " + serverPost + "\t id" + id;
    }
}
