package com.chuixue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 丁鹏
 * @version $ Id: PaymentNacosMain9001, v 0.1 2022/04/12 15:45 peng.ding Exp $
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosMain9011 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosMain9011.class, args);
    }
}
