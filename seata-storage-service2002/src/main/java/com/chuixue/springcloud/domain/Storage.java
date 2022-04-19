package com.chuixue.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 丁鹏
 * @version $ Id: Storage, v 0.1 2022/04/19 11:06 peng.ding Exp $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    private String productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
