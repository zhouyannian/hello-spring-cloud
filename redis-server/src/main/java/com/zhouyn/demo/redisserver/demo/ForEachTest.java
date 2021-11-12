package com.zhouyn.demo.redisserver.demo;

import java.math.BigDecimal;

public class ForEachTest {
    public static void main(String[] args) {
//        List<Integer> strList1 = Lists.newArrayList();
//        List<Integer> strList2 = Lists.newArrayList();
//        for (int i = 0; i < 100000; i++) {
//            strList1.add(i);
//        }
//        for (int i = 100000; i > 0; i--) {
//            strList2.add(i);
//        }
//
//        Long startTime = System.currentTimeMillis();

//        for (Integer integer : strList1) {
//            for (Integer integer1 : strList2) {
//                if(integer.equals(integer1)) {
//                    System.out.println("找到了：" + integer);
//                    break;
//                }
//            }
//        }
//        strList1.stream()
//                .filter(integer -> strList2.stream()
//                        .filter(integer1 -> integer1.equals(integer)))
//                .
//        System.out.println("用时=" + (System.currentTimeMillis() - startTime)/1000 + "秒。");

        System.out.println(new BigDecimal("5000.0000").compareTo(new BigDecimal("5000.00")));

        int d1 = 78;
        int d2 = 100;
        System.out.println(d1 % d2);
    }
}
