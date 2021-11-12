package com.zhouyn.demo.redisserver.demo;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class SplitTest {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        if (StringUtils.isNotBlank(sb)) {
            System.out.println("hello");
        }

        if (Objects.isNull(sb)) {
            System.out.println("null");
        }

        System.out.println("end");


//        String str = "10-20-";
//        System.out.println(str.split("-")[0]);
//        System.out.println(str.split("-").length);
//        System.out.println(str.substring(0,str.length() -1));
//        System.out.println(new SplitTest().reverse(123));
//        List<User> list = Lists.newArrayList();
//        User user1 = User.builder().userName("A").money(new BigDecimal("100.00")).build();
//        User user2 = User.builder().userName("B").money(new BigDecimal("1.97")).build();
//        User user3 = User.builder().userName("C").money(new BigDecimal("56.04")).build();
//        User user4 = User.builder().userName("D").money(new BigDecimal("560.04")).build();
//        list.add(user1);
//        list.add(user2);
//        list.stream()
//                .sorted(Comparator.comparing(User::getMoney))
//                .collect(Collectors.toList());
//        list.add(user3);
//        list.add(user4);
//
//        List<User> list2 = list.stream()
//                .sorted(Comparator.comparing(User::getMoney).reversed())
//                .collect(Collectors.toList());
//        System.out.println(list.stream()
//                .sorted(Comparator.comparing(User::getMoney).reversed())
//                .collect(Collectors.toList()));
////        Collections.reverse(list2);
////        System.out.println(list2.toString());
//
//        int c = 'A';
//        System.out.println(c);

    }

    public int reverse(int x) {
        if (x >= Math.pow(-2, 31) && x <= Math.pow(2, 31) - 1) {
            String strX = String.valueOf(x);
            String result = "";
            StringBuilder sb = new StringBuilder();
            if (x < 0) {
                for (int i = 1; i < strX.length(); i++) {
                    sb.append(strX.charAt(i));
                }
                result = "-" + sb.reverse().toString();
            } else {
                for (int i = 0; i < strX.length(); i++) {
                    sb.append(strX.charAt(i));
                }
                result = sb.reverse().toString();
            }
            Long longResult = Long.parseLong(result);
            if (longResult > Math.pow(2, 31) - 1 || longResult < Math.pow(-2, 31)) {
                return 0;
            }
            return Integer.parseInt(result);
        }
        return 0;
    }
}
