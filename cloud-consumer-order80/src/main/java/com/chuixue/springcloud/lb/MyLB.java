package com.chuixue.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 丁鹏
 * @version $ Id: MyLB, v 0.1 2022/04/07 17:44 peng.ding Exp $
 */
@Component
public class MyLB implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int count;
        int next;
        do {
            count = this.atomicInteger.get();
            next = count >= 2147483647 ? 0 : count + 1;
        } while (!this.atomicInteger.compareAndSet(count, next));
        System.out.println("*******调用次数：next===" + next);
        return next;
    }

    @Override
    public ServiceInstance chooseInstance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
