package com.zhouyn.demo.redisserver.demo;

public class TestSplit {
    public static void main(String[] args) {
        String str = "123";

        String[] strArray = str.split("");

        for (String s : strArray) {
            System.out.println(s);
        }
    }
}
