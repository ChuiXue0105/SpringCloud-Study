package com.chuixue.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 丁鹏
 * @version $ Id: StorageDao, v 0.1 2022/04/19 11:08 peng.ding Exp $
 */
@Mapper
public interface StorageDao {

    // 扣减库存
    void decrease(@Param("productId") String productId, @Param("count") Integer count);
}
