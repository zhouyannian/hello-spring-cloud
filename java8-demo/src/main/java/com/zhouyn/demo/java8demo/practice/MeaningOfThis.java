/**
 * Copyright (c) 2020,TravelSky.
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 */
package com.zhouyn.demo.java8demo.practice;

/**
 * MeaningOfThis
 *
 * @author: zhouyn
 * @data: 2020/1/10 15:26
 * @description: 描述
 * @version: 1.0
 **/
public class MeaningOfThis {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        MeaningOfThis m = new MeaningOfThis();

        // 这一行的输出是什么?
        m.doIt();
    }
}
