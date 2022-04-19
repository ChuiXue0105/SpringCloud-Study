package com.chuixue.springcloud.controller;

import com.chuixue.springcloud.domain.CommonResult;
import com.chuixue.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author 丁鹏
 * @version $ Id: AccountController, v 0.1 2022/04/19 14:58 peng.ding Exp $
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 扣减余额
    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "余额扣减成功");
    }
}
