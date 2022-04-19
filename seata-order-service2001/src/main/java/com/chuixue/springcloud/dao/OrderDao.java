package com.chuixue.springcloud.dao;

import com.chuixue.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 丁鹏
 * @version $ Id: OrderDao, v 0.1 2022/04/18 22:21 peng.ding Exp $
 */
@Mapper
public interface OrderDao {

    //1. 新建订单
    void create(Order order);

    //2. 修改订单状态，从0改为1
    void update(@Param("userId") String userId, @Param("status") Integer status);
}
