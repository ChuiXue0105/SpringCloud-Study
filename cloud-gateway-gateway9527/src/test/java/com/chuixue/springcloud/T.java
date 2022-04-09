package com.chuixue.springcloud;

import java.time.ZonedDateTime;

/**
 * @author 丁鹏
 * @version $ Id: T, v 0.1 2022/04/09 21:57 peng.ding Exp $
 */
public class T {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();      // 默认时区获取当前时间
        System.out.println(zonedDateTime);
    }
}
