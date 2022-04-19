package com.chuixue.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chuixue.springcloud.entities.CommonResult;

/**
 * @author 丁鹏
 * @version $ Id: GlobleBlockHandler, v 0.1 2022/04/16 18:02 peng.ding Exp $
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(4444, "全局自定义限流处理======1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "全局自定义限流处理======2");
    }
}
