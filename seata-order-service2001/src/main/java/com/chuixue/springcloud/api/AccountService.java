package com.chuixue.springcloud.api;

import com.chuixue.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author 丁鹏
 * @version $ Id: AccountService, v 0.1 2022/04/18 22:43 peng.ding Exp $
 */
@Component
@FeignClient(value = "seata-account-service")
public interface AccountService {

    // 扣减余额
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);
}
