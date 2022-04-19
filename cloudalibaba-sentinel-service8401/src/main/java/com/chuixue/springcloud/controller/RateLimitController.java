package com.chuixue.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.chuixue.springcloud.entities.CommonResult;
import com.chuixue.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 丁鹏
 * @version $ Id: RateLimitController, v 0.1 2022/04/16 17:59 peng.ding Exp $
 */
@RestController
public class RateLimitController {

    @GetMapping("/rate/byCustomerBlockHandler")
    @SentinelResource(value = "byCustomerBlockHandler",
    blockHandlerClass = CustomerBlockHandler.class,
    blockHandler = "handlerException2")     //指定我们共有类里面的具体那个方法
    public CommonResult byCustomerBlockHandler() {
        return new CommonResult(200, "按客户自定义限流处理逻辑");
    }
}
