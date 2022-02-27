package com.concurrent.source.thread.juc.volatiledemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: source-demo
 * @description:
 * @ClassName：TestVolatile
 * @author: Mr.Wang
 * @create: 2022-02-22 15:26
 **/
public class TestVolatile {
    private static volatile int  num = 0;
    private static AtomicInteger nunit = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        volatileDemo();
        volatileDemo1();
    }

    private static void volatileDemo1() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    nunit.incrementAndGet();//自增，功能上相当于num++，原子操作
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println(nunit);
    }
    private static void volatileDemo() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    num++; //不是一个原子性操作
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(num);
    }
}
