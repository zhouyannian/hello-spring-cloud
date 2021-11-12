package com.zhouyn.demo.redisserver.demo;

public class StackOverflowErrorTest {

    private int length;

    public int getLength() {
        return length;
    }

    public void test() {
        this.length++;

        test();
    }

    public static void main(String[] args) {
        StackOverflowErrorTest test = new StackOverflowErrorTest();

        try {
            test.test();
        } catch (Throwable ex) {
            System.out.println(test.getLength());
            ex.printStackTrace();
        }
    }
}
