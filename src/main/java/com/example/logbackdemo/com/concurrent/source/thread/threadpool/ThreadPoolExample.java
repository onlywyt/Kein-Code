package com.example.logbackdemo.com.test.source.thread.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @program: source-demo
 * @description: 自定义阻塞队列，实现阻塞队列容量自定义
 * @ClassName：ThreadPoolExample
 * @author: Mr.Wang
 * @create: 2022-01-24 17:15
 **/
public class ThreadPoolExample {
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2,6,60, TimeUnit.SECONDS,new ResizeLinkedBlockQueue<>(20));
    public static void executeTask(){
        IntStream.range(0, 20).forEach(i -> threadPoolExecutor.execute(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
        printPollStatus("before");
        threadPoolExecutor.setCorePoolSize(7);
        threadPoolExecutor.setMaximumPoolSize(14);
        ResizeLinkedBlockQueue rlb = (ResizeLinkedBlockQueue) threadPoolExecutor.getQueue();
        rlb.setCapacity(60);
        printPollStatus("after");
    }

    public static void printPollStatus(String name){
        System.out.println("---------"+name+"-----------");
        ResizeLinkedBlockQueue linkedBlockingQueue = (ResizeLinkedBlockQueue) threadPoolExecutor.getQueue();
        System.out.println("核心线程数："+threadPoolExecutor.getCorePoolSize());
        System.out.println("最大线程数："+threadPoolExecutor.getMaximumPoolSize());
        System.out.println("队列容量："+(linkedBlockingQueue.size() + linkedBlockingQueue.remainingCapacity()));
    }
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        executeTask();

    }
}
