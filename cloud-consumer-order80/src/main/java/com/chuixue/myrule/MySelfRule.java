package com.chuixue.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 丁鹏
 * @version $ Id: MySelfRule, v 0.1 2022/04/05 22:48 peng.ding Exp $
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();    //定义为随机
    }
}
