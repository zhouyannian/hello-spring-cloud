package com.zhouyn.demo.redisserver.demo;

public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(TestFinal.x);
    }
}

class TestFinal {
    public static final int x = 666;

    static {
        System.out.println("FinalTest static block");
    }
}
