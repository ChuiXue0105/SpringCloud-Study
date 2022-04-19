package com.chuixue.springcloud.service.impl;

import com.chuixue.springcloud.api.AccountService;
import com.chuixue.springcloud.api.StorageService;
import com.chuixue.springcloud.dao.OrderDao;
import com.chuixue.springcloud.domain.Order;
import com.chuixue.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 丁鹏
 * @version $ Id: OrderServiceImpl, v 0.1 2022/04/18 22:34 peng.ding Exp $
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减余额->修改订单状态
     * 简单说：下订单->减库存->减余额->改状态
     */

    @Override
    @GlobalTransactional(name = "seata-order-create", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("开始创建订单");
        //1. 新建订单
        orderDao.create(order);

        log.info("调用库存服务扣减库存count==开始");
        //2. 扣减库存
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("调用库存服务扣减库存count==结束");

        log.info("调用账户服务扣减余额money==开始");
        //3. 扣减余额
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("调用账户服务扣减余额money==结束");

        log.info("修改订单状态==开始");
        //4. 修改订单状态，从0到1,1代表已完成
        orderDao.update(order.getUserId(), 1);
        log.info("修改订单状态==结束");

        log.info("下订单已完结O(∩_∩)O哈哈~");
    }

}
