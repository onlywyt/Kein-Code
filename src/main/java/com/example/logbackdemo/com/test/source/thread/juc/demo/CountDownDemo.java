package com.example.logbackdemo.com.test.source.thread.juc.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CountDownDemo
 * @author: Mr.Wang
 * @create: 2022-02-11 12:47
 **/
public class CountDownDemo {

    /**
     * 首先构建了一个倒计时为2的CountDownLatch实例。
     * 定义两个线程分别执行RelationService线程，在线程中调用countDownLatch.countDown()方法，
     * 表示对倒计时进行递减，其实也可以认为当前线程的某个任务执行完毕。
     * main线程调用countDownLatch.await()方法进行阻塞，当计数器为0时被唤醒。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new RelationService(countDownLatch),"t1").start();
        new Thread(new RelationService(countDownLatch),"t2").start();
        new Thread(new RelationService(countDownLatch),"t3").start();
        countDownLatch.await();
        System.out.println("main线程唤醒");
    }

    static class RelationService implements Runnable {
        private CountDownLatch countDownLatch ;
        public RelationService(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+ "-> done");
            countDownLatch.countDown();
        }
    }
}
