package com.chuixue.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 丁鹏
 * @version $ Id: Payment, v 0.1 2022/04/04 15:44 peng.ding Exp $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
