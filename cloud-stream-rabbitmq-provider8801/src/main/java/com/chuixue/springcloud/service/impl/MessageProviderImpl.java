package com.chuixue.springcloud.service.impl;

import com.chuixue.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 丁鹏
 * @version $ Id: MessageProviderImpl, v 0.1 2022/04/11 18:17 peng.ding Exp $
 */
@EnableBinding(Source.class)    // 可以理解为是一个消息发送管道的定义
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  // 消息的发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        this.output.send(MessageBuilder.withPayload(serial).build());   // 创建并发送消息
        System.out.println("*****serial: " + serial);
        return serial;
    }
}
