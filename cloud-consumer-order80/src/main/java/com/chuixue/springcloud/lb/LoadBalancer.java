package com.chuixue.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 丁鹏
 * @version $ Id: LoadBalancer, v 0.1 2022/04/07 17:43 peng.ding Exp $
 */
public interface LoadBalancer {
    ServiceInstance chooseInstance(List<ServiceInstance> serviceInstances);
}
