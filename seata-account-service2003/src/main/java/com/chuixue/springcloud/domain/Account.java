package com.chuixue.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 丁鹏
 * @version $ Id: Account, v 0.1 2022/04/19 14:44 peng.ding Exp $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
