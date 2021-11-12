package com.zhouyn.demo.redisserver.demo;

/**
 * 模拟 cpu 飙升场景
 *
 * @author zhouyn
 * @date 2021年11月11日 17:37
 */
public class CpuReaper {
    public static void main(String[] args) {
        int num = 0;
        long start = System.currentTimeMillis() / 1000;
        while (true) {
            num = num + 1;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
                num = 0;
            }
            if ((System.currentTimeMillis() / 1000) - start > 1000) {
                return;
            }
        }
    }
}
