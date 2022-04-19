package com.chuixue.springcloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author 丁鹏
 * @version $ Id: StorageService, v 0.1 2022/04/19 11:14 peng.ding Exp $
 */
public interface StorageService {

    // 扣减库存
    void decrease(String productId, Integer count);
}
