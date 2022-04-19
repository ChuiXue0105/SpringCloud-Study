package com.chuixue.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chuixue.springcloud.entities.CommonResult;
import com.chuixue.springcloud.entities.Payment;
import com.chuixue.springcloud.service.PaymentService;
import com.sun.deploy.security.BlockedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 丁鹏
 * @version $ Id: CircleBreakerController, v 0.1 2022/04/17 15:56 peng.ding Exp $
 */
@RestController
public class CircleBreakerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceURL;

    @GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")   //没有配置
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")     //fallback只负责业务异常
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")      //blockHandler只负责sentinel控制台配置违规
    //@SentinelResource(value = "fallback", fallback = "handlerFallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serviceURL + "/paymentSQL/" + id, CommonResult.class);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 该ID没有对应记录，空指针异常....");
        }

        return result;
    }

    //本例是fallback
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常handlerFallback, exception内容" + e.getMessage(), payment);
    }

    //本例是blockHandler
    public CommonResult blockHandler(Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(555, "blockHandler-sentinel限流, 无此流水: blockException" + blockException.getMessage(), payment);
    }


    //==============OpenFeign================
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/feign/fallback/{id}")
    @SentinelResource(value = "feignFallback", blockHandler = "feignBlockHandler")
    public CommonResult<Payment> feignFallback(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }

    public CommonResult feignBlockHandler(Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(9999999, "blockHandler-sentinel限流, 无此流水: blockException" + blockException.getMessage(), payment);
    }
}
