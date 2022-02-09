package com.example.logbackdemo.com.test.source.thread.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ReentrantLockDemo
 * @author: Mr.Wang
 * @create: 2022-01-27 10:37
 **/
public class ReentrantLockDemo {
    static ReentrantLock lock = new ReentrantLock();
    private int count = 0;
    public void incr(){
        lock.lock();
        try {
            count++;
        } finally {
          lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo atomicExample = new ReentrantLockDemo();
        Thread[] threads = new Thread[2];
        for (int i = 0; i < 2; i++) {
            threads[i]=new Thread(() ->{
                for (int j = 0; j < 10000; j++) {
                    atomicExample.incr();
                }
            });
            threads[i].start();
        }
        threads[0].join();
        threads[1].join();
        System.out.println(atomicExample.count);
    }
}
