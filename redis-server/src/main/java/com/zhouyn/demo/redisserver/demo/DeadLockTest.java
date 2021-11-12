package com.zhouyn.demo.redisserver.demo;

public class DeadLockTest {
    public static void main(String[] args) {
        new Thread(() -> A.method()).start();

        new Thread(() -> B.method()).start();
    }

}

class A {

    public static synchronized void method() {
        System.out.println("method from A");

        try {
            Thread.sleep(1000);

            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B {

    public static synchronized void method() {
        System.out.println("method from B");

        try {
            Thread.sleep(1000);

            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



