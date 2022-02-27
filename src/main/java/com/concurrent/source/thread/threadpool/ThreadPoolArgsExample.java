package com.concurrent.source.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ThreadPoolArgsExample
 * @author: Mr.Wang
 * @create: 2022-01-24 16:43
 **/
public class ThreadPoolArgsExample {

    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2,6,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(16));
    public static void executeTask(){
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(() ->{
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                 e.printStackTrace();
                }
            });
        }
        printPollStatus("before");
        threadPoolExecutor.setCorePoolSize(7);
        threadPoolExecutor.setMaximumPoolSize(14);
        printPollStatus("after");
    }

    public static void printPollStatus(String name){
        System.out.println("---------"+name+"-----------");
        LinkedBlockingQueue linkedBlockingQueue = (LinkedBlockingQueue) threadPoolExecutor.getQueue();
        System.out.println("核心线程数："+threadPoolExecutor.getCorePoolSize());
        System.out.println("最大线程数："+threadPoolExecutor.getMaximumPoolSize());
        System.out.println("队列中的任务个数："+linkedBlockingQueue.size());
    }
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        executeTask();

    }
}
