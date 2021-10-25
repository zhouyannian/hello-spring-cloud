package com.zhouyn.demo.controller;

import java.util.Arrays;
import java.util.List;

/**
 * 类名
 *
 * @Author: zhouyn
 * @Data: 2019/8/29 13:29
 * @Description: 描述
 * @Version: 1.0
 **/
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3","4");

        list.stream()
                .filter( str -> str.equals("4"))
                .findAny()
                .ifPresent(System.out::println);

        Object obj = new Object();
    }
}
