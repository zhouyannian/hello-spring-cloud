package com.zhouyn.demo.serviceConsumer.controller;

public class Test {
    public static void main(String[] args) {
        String str = "  hello";
        System.out.println(str);
        System.out.println("after=[" + str.substring(str.lastIndexOf(" ") + 1) + "]");
        System.out.println("after=" + str.replaceAll(" ", "").length());
    }
}
