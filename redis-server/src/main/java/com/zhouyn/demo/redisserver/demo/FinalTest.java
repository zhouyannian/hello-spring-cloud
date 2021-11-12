package com.zhouyn.demo.redisserver.demo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhouyn
 */
public class FinalTest {
    public static void main(String[] args) {
//        final int x = 6;
//        String url = "http://srm/goods/hello.jpg";
//        System.out.println(url.substring(url.lastIndexOf("/") + 1, url.indexOf(".")));
        System.out.println(1 % 10000);
        System.out.println(10001 % 10000);

        List<String> strList = Lists.newArrayList("A", "B", "C", "D");

        String x = strList.stream()
                .filter(s -> "E".equals(s))
                .findFirst()
                .orElse("X");
        System.out.println(x);

        String str = null;
        switch (str) {
            case "A":
                System.out.println("A");
                break;
            default:
                break;
        }
    }
}
