package com.zhouyn.demo.redisserver.demo;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;

@EnableAsync
public class AsyncTest {

    public static void main(String[] args) throws InterruptedException {

//        AsyncTest asyncTest = new AsyncTest();
//        asyncTest.testAsync("你好");
//        System.out.println("结束");
        List<Integer> intList = new ArrayList<>(5);
        intList.add(1);
        System.out.println(intList.size());
        intList.add(2);
        System.out.println(intList.size());
        intList.add(3);
        System.out.println(intList.size());

        System.out.println(intList.size());
//        System.out.println(Math.max(10,20));
        System.out.println(Sets.newHashSet(StringUtils.split("1", ",")));

//        System.out.println(10 + (10 >> 1));
    }

    @Async
    public void testAsync(String str) throws InterruptedException {
        System.out.println("异步执行:" + str);
    }
}


