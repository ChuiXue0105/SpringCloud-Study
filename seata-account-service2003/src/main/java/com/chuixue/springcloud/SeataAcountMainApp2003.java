package com.chuixue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 丁鹏
 * @version $ Id: SeataAcountMainApp2003, v 0.1 2022/04/19 14:43 peng.ding Exp $
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消数据源的自动创建
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAcountMainApp2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAcountMainApp2003.class, args);
    }
}
