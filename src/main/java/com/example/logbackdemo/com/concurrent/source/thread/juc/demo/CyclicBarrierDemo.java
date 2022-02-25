package com.example.logbackdemo.com.test.source.thread.juc.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CyclicBarrierDemo
 * @author: Mr.Wang
 * @create: 2022-02-13 18:06
 **/
public class CyclicBarrierDemo {

    /**
     * 因为主线程和子线程的调度是由CPU决定的，两个线程都有可能先执行，所以会产生两种输出 1,2 或者2，1
     */
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (Exception e) {

            }
            System.out.println("1");
        }).start();
        try {
            cyclicBarrier.await();
        } catch (Exception e) {

        }
        System.out.println("2");
    }
}
