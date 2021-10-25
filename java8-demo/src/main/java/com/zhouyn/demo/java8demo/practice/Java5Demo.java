/**
 * Copyright (c) 2020,TravelSky.
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 */
package com.zhouyn.demo.java8demo.practice;

import com.zhouyn.demo.java8demo.constant.DemoConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static com.zhouyn.demo.java8demo.constant.DemoConstant.*;

/**
 * Java5Demo
 *
 * @author: zhouyn
 * @data: 2020/1/9 14:42
 * @description: 描述
 * @version: 1.0
 **/
public class Java5Demo {
    public static void main(String[] args) {

        // 1、自动装箱与拆箱
        int a = new Integer(66);
        Integer b = 18;

        List<Integer> integerList = new ArrayList<>();
        // JDK5之前
        integerList.add(new Integer(5));
        // JDK5之后
        integerList.add(18);

        // 增强for循环
        for (Integer integer : integerList) {
            System.out.println(integer);
        }

        // 静态导入
        System.out.println(DemoConstant.MESSAGE_URL);
        System.out.println(USER_ID);
        System.out.println(USER_PASSWORD);

        // 变长参数
        System.out.println(Java5Demo.add("test", 1, 2, 3, 4, 5));

        // 并发库java.util.concurrent
        ConcurrentHashMap map = new ConcurrentHashMap();
    }

    /**
     * 可变长参数
     *
     * @param name
     * @param nums
     * @return
     */
    public static int add(String name, int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
