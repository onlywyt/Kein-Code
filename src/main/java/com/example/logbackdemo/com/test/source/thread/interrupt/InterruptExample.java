package com.example.logbackdemo.com.test.source.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description: 优雅的终止线程
 * @ClassName：InterruptExample
 * @author: Mr.Wang
 * @create: 2022-01-18 14:00
 **/
public class InterruptExample extends Thread{
    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()){
            i++;
        }
        System.out.println("线程中断：i=" + i );
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptExample interruptExample = new InterruptExample();
        interruptExample.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("before:InterruptExample 中断状态：" + interruptExample.isInterrupted());
        interruptExample.interrupt();
        System.out.println("after:InterruptExample中断状态：" + interruptExample.isInterrupted());
    }
}
