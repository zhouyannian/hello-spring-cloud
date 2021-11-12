package com.zhouyn.demo.redisserver.demo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhouyn
 * @date 2021年06月05日 上午10:08
 */
public class SetsTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("A", "B", "B", "C", "E");

        // fori
//        for (int i = 0; i < list.size(); i++) {
//            if ("B".equals(list.get(i))) {
//                list.remove(list.get(i));
//                i--;
//            }
//        }
//        list.stream()
//                .iterator()
//                .
//        System.out.println(list);
        String str = "WZWD00177001";
        System.out.println(str.substring(0, 9));

        list.stream()
                .filter(str1 -> "B".equals(str1))
                .forEach(str1 -> str1 = str1 + "0");
        System.out.println(list);
    }
}
