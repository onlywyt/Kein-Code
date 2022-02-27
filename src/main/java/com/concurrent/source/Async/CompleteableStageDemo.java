package com.concurrent.source.Async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CompleteableStageDemo
 * @author: Mr.Wang
 * @create: 2022-02-10 18:59
 **/
@Slf4j
public class CompleteableStageDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture future = CompletableFuture
                //第一个任务返回一个字符串
                .supplyAsync(()->"thenAccept message")
                //第二个任务打印这个字符串
                //这两个任务建立了串行执行的关系，也就是第二个CompletionStage任务相当于第一个任务执行结束后的异步回调，
                // 并且多个CompletionStage任务可以使用链式风格串联
                .thenAcceptAsync((request)->{
            log.info(Thread.currentThread().getName()+" 第一个异步任务返回值 "+ request);
        });
        future.get();
    }

}
