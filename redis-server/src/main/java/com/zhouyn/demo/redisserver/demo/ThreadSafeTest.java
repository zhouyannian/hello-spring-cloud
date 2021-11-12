package com.zhouyn.demo.redisserver.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author zhouyn
 * @date 2021年08月17日 下午11:05
 */
public class ThreadSafeTest {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    //    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
    ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));

    public String date(int seconds) {
        Date date = new Date(seconds * 1000);
        return threadLocal.get().format(date);
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(0, 20).forEach(i -> {
//            System.out.println(i);
            int finalI = i;
            threadPool.submit(() -> System.out.println(new ThreadSafeTest().date(i)));
        });
        threadPool.shutdown();
    }
}
