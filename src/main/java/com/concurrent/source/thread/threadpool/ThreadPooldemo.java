package com.concurrent.source.thread.threadpool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ThreadPooldemo
 * @author: Mr.Wang
 * @create: 2022-01-23 16:15
 **/
public class ThreadPooldemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);//创建一个固定数量为5个线程的线程池
        for (int i = 0; i < 12; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();//关闭线程池
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "- Strat ");
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"- 执行完成");
        }
    }
}
