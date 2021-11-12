package com.zhouyn.demo.redisserver.demo;

public class MyTest4 {

    public static void main(String[] args) {
        MyParent4 myParent4 = new MyParent4();
        System.out.println(myParent4.getClass());
    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static code.");
    }
}