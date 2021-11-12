package com.zhouyn.demo.redisserver.demo;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Test {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        System.out.println("不安全的随机数=" + (int) (Math.random() * 10000));
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        System.out.println("安全的随机数=" + random.nextInt());

        Long long1 = 100L;
        String str1 = "100";
        System.out.println(str1.equals(long1.toString()));

        int num = 234;
        int total = 123456;
        System.out.println(Float.parseFloat(String.valueOf(num)) / Float.parseFloat(String.valueOf(total)));

        String string = "//erp-image-1255302958.cos.ap-guangzhou.myqcloud.com/2179d09c-a9b7-4a06-bbb1-2240fd84ad2b-1542132252.jpg";
        System.out.println(string.substring(string.lastIndexOf("/") + 1));
    }
}
