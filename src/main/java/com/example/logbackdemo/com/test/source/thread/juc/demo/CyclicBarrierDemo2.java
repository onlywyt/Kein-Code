package com.example.logbackdemo.com.test.source.thread.juc.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static sun.misc.PostVMInitHook.run;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CyclicBarrierDemo2
 * @author: Mr.Wang
 * @create: 2022-02-13 18:13
 **/
public class CyclicBarrierDemo2 {
    static CyclicBarrier c = new CyclicBarrier(2, new A());
    public static void main(String[] args) {
        new Thread(()->{
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        }).start();

        try {
            c.await();
        } catch (Exception e) {

        }
        System.out.println(2);
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
