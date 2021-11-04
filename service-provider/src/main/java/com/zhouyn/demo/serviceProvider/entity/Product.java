package com.zhouyn.demo.serviceProvider.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Product实体类
 *
 * @author zhouyn(zhouyannian @ 163.com)
 * @data 2019年4月24日下午10点45分
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    // 产品货号
    private String itemCode;
    // 产品名称
    private String name;
    // 产品品牌名称
    private String bandName;
    // 产品价格
    private int price;
}
