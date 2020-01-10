/**
 * Copyright (c) 2020,TravelSky.
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 */
package com.zhouyn.demo.java8demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Apple
 *
 * @author: zhouyn
 * @data: 2020/1/10 14:40
 * @description: 描述
 * @version: 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Apple {

    /**
     * 名称
     */
    private String name;

    /**
     * 颜色
     */
    private String color;

    /**
     * 重量
     */
    private int weight;
}
