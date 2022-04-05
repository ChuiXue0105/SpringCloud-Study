package com.chuixue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 丁鹏
 * @version $ Id: PaymentMain8004, v 0.1 2022/04/05 18:40 peng.ding Exp $
 */
@SpringBootApplication
@EnableDiscoveryClient      // 该注解用于向使用consul或者ZooKeeper作为注册中心时注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
