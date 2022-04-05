package com.chuixue.springcloud.config;

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
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
