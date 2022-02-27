package com.concurrent.source.thread.juc.demo;

import java.util.concurrent.CyclicBarrier;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CountDownDemo3
 * @author: Mr.Wang
 * @create: 2022-02-13 18:21
 **/
public class CountDownDemo3 {
    public static void main(String[] args) {
        int parties = 4;

        CyclicBarrier bar = new CyclicBarrier(parties,()->{
            System.out.println("所有线程执行完毕，继续处理其他任务");
        });
        for (int i = 0; i < parties; i++) {
            new ImportDataThread(bar).start();
        }

    }

    static class ImportDataThread extends Thread {
        private CyclicBarrier barrier;
        public ImportDataThread(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("线程：" + Thread.currentThread().getName() + "数据处理完毕。等待其他线程");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
