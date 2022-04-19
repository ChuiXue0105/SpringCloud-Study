package com.chuixue.springcloud.service.impl;

import com.chuixue.springcloud.dao.AccountDao;
import com.chuixue.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author 丁鹏
 * @version $ Id: AccountServiceImpl, v 0.1 2022/04/19 14:56 peng.ding Exp $
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(String userId, BigDecimal money) {
        log.info("account-server开始扣减余额");

        //模拟超时异常，全局事务回滚
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        accountDao.decrease(userId, money);
        log.info("account-server扣减余额结束");
    }
}
