package com.chuixue.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author 丁鹏
 * @version $ Id: AccountService, v 0.1 2022/04/19 14:51 peng.ding Exp $
 */
public interface AccountService {

    //扣减余额
    void decrease(String userId, BigDecimal money);
}
