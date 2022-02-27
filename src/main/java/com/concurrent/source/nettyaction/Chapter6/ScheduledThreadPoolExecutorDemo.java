package com.concurrent.source.nettyaction.Chapter6;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description: 延迟处理任务
 * @ClassName：ScheduledThreadPoolExecutorDemo
 * @author: Mr.Wang
 * @create: 2022-02-18 16:42
 **/
public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(50);
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("60 Seconds kater");
            }
        },6, TimeUnit.SECONDS);
        executor.shutdown();
    }
}
