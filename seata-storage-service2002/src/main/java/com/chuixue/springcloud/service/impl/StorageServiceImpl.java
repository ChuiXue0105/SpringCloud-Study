package com.chuixue.springcloud.service.impl;

import com.chuixue.springcloud.dao.StorageDao;
import com.chuixue.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 丁鹏
 * @version $ Id: StorageServiceImpl, v 0.1 2022/04/19 11:15 peng.ding Exp $
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(String productId, Integer count) {
        log.info("storage-server开始扣减库存");
        storageDao.decrease(productId, count);
        log.info("storage-server扣减库存结束");
    }
}
