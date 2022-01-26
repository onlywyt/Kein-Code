package com.example.logbackdemo.com.test.source.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description: 优雅的终止阻塞的线程
 * @ClassName：BlockThreadInterruptExample
 * @author: Mr.Wang
 * @create: 2022-01-18 14:55
 **/
public class BlockThreadInterruptExample extends Thread {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                TimeUnit.SECONDS.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
                //如果在抛出异常之后仍然要终止线程，则需要调用Thread.currentThread().interrupt()
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("线程被中断");
    }

    public static void main(String[] args) throws Exception {
        //抛出异常：InterruptedException: sleep interrupted
        //如果在抛出异常之后仍然要终止线程，则需要调用Thread.currentThread().interrupt()
        BlockThreadInterruptExample example = new BlockThreadInterruptExample();
        example.start();
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("before：IntreruptExaple中断状态：" + example.isInterrupted());
        example.interrupt();
        System.out.println("after：IntreruptExaple中断状态：" + example.isInterrupted());
    }
}
