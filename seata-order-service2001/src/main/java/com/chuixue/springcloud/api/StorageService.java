package com.chuixue.springcloud.api;

import com.chuixue.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 丁鹏
 * @version $ Id: StorageService, v 0.1 2022/04/18 22:43 peng.ding Exp $
 */
@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    // 扣减库存
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") String productId, @RequestParam("count") Integer count);
}
