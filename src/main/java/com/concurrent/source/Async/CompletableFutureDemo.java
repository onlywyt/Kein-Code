package com.concurrent.source.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @program: source-demo
 * @description: runAsync()和SupplyAsync() 两种构建异步事件的方法。
 * @ClassName：CompletableFutureDemo
 * @author: Mr.Wang
 * @create: 2022-02-09 18:04
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        runAsyncDemo();
        supplyAsyncDemo();
        supplyAsyncDemo1();
    }

    private static void supplyAsyncDemo() throws InterruptedException, ExecutionException {
        CompletableFuture cf = CompletableFuture.supplyAsync(()->{
            return "supplyAsync";
        });
        System.out.println(cf.get());//supplyAsync()有返回值，所以返回supplyAsync
    }

    private static void supplyAsyncDemo1() throws InterruptedException, ExecutionException {
        Executor executor = Executors.newSingleThreadExecutor();

        CompletableFuture cf = CompletableFuture.supplyAsync(()->{
           Thread.currentThread().setName("zidnyi");
            return Thread.currentThread().getName() + ": supplyAsync";
        },executor);
        System.out.println(cf.get());//supplyAsync()有返回值，所以返回supplyAsync
    }


    private static void runAsyncDemo() throws InterruptedException, ExecutionException {
        CompletableFuture cf = CompletableFuture.runAsync(()-> System.out.println(Thread.currentThread().getName() + "这是一个异步任务"));
        System.out.println(cf.get());//runAsync()无返回值，所以返回null
    }
}
