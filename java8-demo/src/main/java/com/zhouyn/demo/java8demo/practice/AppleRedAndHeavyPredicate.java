/**
 * Copyright (c) 2020,TravelSky.
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 */
package com.zhouyn.demo.java8demo.practice;

import com.zhouyn.demo.java8demo.entity.Apple;

/**
 * AppleRedColorPredicate
 *
 * @author: zhouyn
 * @data: 2020/1/10 15:09
 * @description: 描述
 * @version: 1.0
 **/
public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() > 130;
    }
}
