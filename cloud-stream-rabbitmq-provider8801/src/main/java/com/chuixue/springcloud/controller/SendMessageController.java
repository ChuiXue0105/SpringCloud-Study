package com.chuixue.springcloud.controller;

import com.chuixue.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 丁鹏
 * @version $ Id: SendMessageController, v 0.1 2022/04/11 18:25 peng.ding Exp $
 */
@RestController
@Slf4j
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
