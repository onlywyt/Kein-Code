package com.concurrent.source.thread.juc.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CountDownLatchTest
 * @author: Mr.Wang
 * @create: 2022-02-13 17:45
 **/
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(2);
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("3");
    }
}
