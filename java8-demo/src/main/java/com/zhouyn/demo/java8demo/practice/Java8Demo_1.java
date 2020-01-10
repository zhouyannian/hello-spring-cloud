/**
 * Copyright (c) 2020,TravelSky.
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 */
package com.zhouyn.demo.java8demo.practice;

import com.zhouyn.demo.java8demo.entity.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Java8Demo_1
 *
 * @author: zhouyn
 * @data: 2020/1/10 14:36
 * @description: 行为参数化
 * @version: 1.0
 **/
public class Java8Demo_1 {
    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("红富士", "red", 150));
        inventory.add(new Apple("青苹果", "green", 120));
        inventory.add(new Apple("美国蛇果", "red", 200));

        // 第一种方式
        List<Apple> redAppleList = filterGreenApples(inventory);

        // 第二种方式
        List<Apple> greenAppleList = filterGreenApplesByColor(inventory, "green");

        // 筛选重量大于130克的苹果
        List<Apple> appleList = filterApplesByWeight(inventory, 130);

        // 第三种方式
        List<Apple> flagAppleList = filterApples(inventory, "red", 130, true);

        // 第四种方式
        List<Apple> predicateAppleList = filterApplesByPredicate(inventory, new AppleRedAndHeavyPredicate());

        // 第五种方式：匿名内部类
        List<Apple> redApple = filterApplesByPredicate(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        // 第六种方式：使用Lambda表达式
        List<Apple> LambdaRedApple = filterApplesByPredicate(inventory, (Apple apple) -> "red".equals(apple.getColor()));
    }


    /**
     * 从列表中筛选颜色为红色的苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if ("red".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 从列表中筛选指定颜色的苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 从列表中筛选指定重量的苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 从列表中筛选指定重量的苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if ((flag && color.equals(apple.getColor())) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 从列表中筛选指定的苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterApplesByPredicate(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
