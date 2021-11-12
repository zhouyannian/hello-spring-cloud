package com.zhouyn.demo.redisserver.demo;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * @author zhouyn
 * @date 2021年07月06日 下午11:49
 */
public class ThreadTest {

//    ExecutorService executorService = Executors.newFixedThreadPool(3);
//    ExecutorService executorService2 = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
//        new Thread(() -> System.out.println("1当前线程=" + Thread.currentThread().getName())).start();
//        new Thread(() -> System.out.println("2当前线程=" + Thread.currentThread().getName())).run();

//        boolean flag = true;
//        System.out.println(flag ^= false);
//        int c = 10;
//        // 8 4 2 1
//        // 1010 0101 4+1
//        System.out.println(~c);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();
        ThreadPoolExecutor threadPool =
                new ThreadPoolExecutor(2, 5, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
//        threadPool.allowCoreThreadTimeOut(true);
        IntStream.rangeClosed(1, 2).forEach(i -> {
            threadPool.execute(() -> {
                System.out.println(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            if (i == 5) {
                System.out.println("修改核心线程数之前：" + threadPool.getPoolSize());
                threadPool.setCorePoolSize(3);
                System.out.println("更改核心线程数后:" + threadPool.getPoolSize());
            }
        });
        // 等待任务执行完成
        Thread.sleep(1000);
        System.out.println("执行前:" + threadPool.getPoolSize());
        threadPool.allowCoreThreadTimeOut(true);
        System.out.println("执行后:" + threadPool.getPoolSize());
        System.out.println("123".equals("1 23"));
    }
}
