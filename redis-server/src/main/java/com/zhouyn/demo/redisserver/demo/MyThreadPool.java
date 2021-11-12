package com.zhouyn.demo.redisserver.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

/**
 * 归属人
 *
 * @author zhouyn
 * @date 2021年07月02日 上午11:25
 */
@Slf4j
public class MyThreadPool {

    BlockingDeque<Runnable> taskQueue;
    List<Thread> threadList;

    public MyThreadPool(BlockingDeque<Runnable> taskQueue, int threadSize) {
        this.taskQueue = taskQueue;
        threadList = new ArrayList<>(threadSize);

        // 初始化行程并定义名称
        IntStream.rangeClosed(1, threadSize)
                .forEach(i -> {
                    MyThread thread = new MyThread("my-task-thread-" + i);
                    thread.start();
                    threadList.add(thread);
                });
    }

    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Runnable task = null;
            while (true) {
                try {
                    task = taskQueue.take();
                } catch (InterruptedException e) {
                    log.error("出错了!");
                    e.printStackTrace();
                }
                task.run();
            }
        }
    }

    public static void main(String[] args) {

        MyThreadPool myThreadPool = new MyThreadPool(new LinkedBlockingDeque<>(10), 3);
        IntStream.rangeClosed(1, 5).forEach(i -> {
            try {
                Runnable runnable = () -> System.out.println("当前执行线程:" + Thread.currentThread().getName());
                myThreadPool.execute(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("出错了！");
            }
        });
    }
}
