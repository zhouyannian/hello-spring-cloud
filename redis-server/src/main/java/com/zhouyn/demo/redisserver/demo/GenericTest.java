package com.zhouyn.demo.redisserver.demo;

public class GenericTest {
    public static void main(String[] args) {

        Pair<String> p1 = new Pair<>("Hello", "world");
        Pair<Integer> p2 = new Pair<>(123, 456);
        System.out.println("p1.class = " + p1.getClass());
        System.out.println("p2.class = " + p2.getClass());
        System.out.println(p1.getClass() == p2.getClass());
    }
}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}
