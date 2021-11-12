package com.zhouyn.demo.redisserver.demo;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author zhouyn
 * @date 2021年09月16日 上午10:08
 */
public class GCTargetWeakReference extends WeakReference<GCTest> {

    // 弱引用的id
    public String id;

    public GCTargetWeakReference(GCTest referent, String id) {
        super(referent);
        this.id = id;
    }

    public GCTargetWeakReference(GCTest referent, ReferenceQueue<? super GCTest> q, String id) {
        super(referent, q);
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing GCTargetWeakReference " + id);
        Thread thread = Thread.currentThread();
    }
}
