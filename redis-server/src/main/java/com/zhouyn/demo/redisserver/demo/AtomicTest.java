package com.zhouyn.demo.redisserver.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author zhouyn
 * @date 2021年08月18日 下午11:23
 */
public class AtomicTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Count count = new Count();
        IntStream.rangeClosed(1, 100).forEach(i ->
                threadPool.execute(() -> count.increase()));

        threadPool.shutdown();
        ;
        threadPool.awaitTermination(1, TimeUnit.DAYS);

        System.out.println(count.getCount());

    }
}

class Count {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void increase() {
        count++;
    }
}
