package com.zhouyn.demo.redisserver.demo;

/**
 * @author zhouyn
 * @date 2021年09月16日 上午10:05
 */
public class GCTest {

    // 对象的ID
    public String id;

    // 占用内存空间
    byte[] buffer = new byte[1024];

    public GCTest(String id, byte[] buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    protected void finalize() throws Throwable {
        // 执行垃圾回收时打印显示对象ID
        System.out.println("Finalizing GCTarget, id is : " + id);
    }
}
