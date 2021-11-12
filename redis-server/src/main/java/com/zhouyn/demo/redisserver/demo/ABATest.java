package com.zhouyn.demo.redisserver.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zhouyn
 * @date 2021年07月06日 下午11:09
 */
public class ABATest {

    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static AtomicStampedReference<Integer> atomicStampedReference =
            new AtomicStampedReference<>(100, 0);


    public static void main(String[] args) throws InterruptedException {
        Thread intT1 = new Thread(() -> {
            atomicInteger.compareAndSet(100, 101);
            atomicInteger.compareAndSet(101, 100);
        });

        Thread intT2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean c3 = atomicInteger.compareAndSet(100, 101);
            System.out.println(c3);
        });

        intT1.start();
        intT2.start();
        intT1.join();
        intT2.join();

        Thread refT1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            atomicStampedReference.compareAndSet(101, 100,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        });

        Thread refT2 = new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("before sleep:stamp = " + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after sleep:stamp = " + atomicStampedReference.getStamp());
            boolean c3 = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println(c3);
        });

        refT1.start();
        refT2.start();

    }
}
