package com.chuixue.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author 丁鹏
 * @version $ Id: AccountDao, v 0.1 2022/04/19 14:46 peng.ding Exp $
 */
@Mapper
public interface AccountDao {

    //扣减余额
    void decrease(@Param("userId") String userId, @Param("money") BigDecimal money);
}
