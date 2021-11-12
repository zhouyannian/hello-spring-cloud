package com.zhouyn.demo.redisserver.jvm;

public class MyTest5 {
    public static void main(String[] args) {
        MyChild5 myChild5 = new MyChild5();
        System.out.println(myChild5.a);
    }
}

class MyParent5 implements MyParent5_1 {
    static {
        System.out.println("MyParent5 class invoked");
    }
}

class MyChild5 extends MyParent5 {
    {
        System.out.println("MyChild5 class invoked");
    }

    public int a = 5;
}

interface MyParent5_1 {
    public Thread thread = new Thread() {
        {
            System.out.println("MyParent5_1 interface invoked");
        }
    };
}

interface MyChild5_1 extends MyParent5_1 {
    public Thread thread = new Thread() {
        {
            System.out.println("MyParent5_1 interface invoked");
        }
    };
}
