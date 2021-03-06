package com.chuixue.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 丁鹏
 * @version $ Id: ApplicationContextConfig, v 0.1 2022/04/04 20:42 peng.ding Exp $
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced     // 不加该注解，消费者通过微服务名称调提供者会报错
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
