package com.example.logbackdemo.com.test.source.thread.juc;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: source-demo
 * @description:
 * @ClassName：MyLock
 * @author: Mr.Wang
 * @create: 2022-01-27 13:56
 **/
public class MyLock extends AbstractQueuedSynchronizer {

    public void tryLock(){
        int state = getState();
        if (state==0){//表示当前锁资源空闲。
            System.out.println("当前锁资源空闲。");
        } else{
            System.out.println("表示有线程已经抢占到锁但还没释放，在重入的情况下state有可能是一个大于1的值");
        }
    }

    /**
     * 独占方式，尝试获取资源，成功返回true，失败返回false
     * @param arg
     * @return
     */
    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    /**
     * 独占方式，尝试释放资源，成功返回true，失败返回false
     * @param arg
     * @return
     */
    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    /**
     * 共享方式，尝试释放资源，如果释放后允许唤醒后续等待节点则返回true，否则返回false
     * @param arg
     * @return
     */
    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    /**
     * 共享方式。尝试获取资源。负数表示失败；0表示成功，但没有剩余可用资源；正数表示成功，且有剩余可用资源。
     * @param arg
     * @return
     */
    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }


}
