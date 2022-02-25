package com.example.logbackdemo.com.test.source.thread.juc.demo;

import static sun.misc.PostVMInitHook.run;

/**
 * @program: source-demo
 * @description:
 * @ClassName：JoinLatchTest
 * @author: Mr.Wang
 * @create: 2022-02-13 17:51
 **/
public class JoinLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("thread3");
        });
        thread3.start();
        thread3.join();
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        System.out.println("all thread is finish");
    }
}
