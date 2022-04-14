package com.chuixue.springcloud.controller;

import com.chuixue.springcloud.entities.CommonResult;
import com.chuixue.springcloud.entities.Payment;
import com.chuixue.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 丁鹏
 * @version $ Id: PaymentController, v 0.1 2022/04/04 16:03 peng.ding Exp $
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("*******插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID:" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service :
                services) {
            log.info("*************service==" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance :
                instances) {
            log.info("*************instance==" + instance);
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getInstanceId() + "\t" + instance.getUri());
        }

        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    //消息链路监控sleuth+zipkin
    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin() {
        return "hi, i am paymentzipkin server fall back, welcome to chuixue, O(∩_∩)O哈哈~";
    }
}
