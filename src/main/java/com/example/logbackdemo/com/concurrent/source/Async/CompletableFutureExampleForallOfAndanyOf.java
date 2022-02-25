package com.example.logbackdemo.com.test.source.Async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CompletableFutureExampleForallOfAndanyOff
 * @author: Mr.Wang
 * @create: 2022-02-09 18:10
 **/
@Slf4j
public class CompletableFutureExampleForallOfAndanyOf {

    public static void main(String[] args) {
        //allOfDemo();
        anyOfDemo();
    }

    private static void allOfDemo() {
        CompletableFuture<Void> v1 = CompletableFuture.runAsync(() ->{
            log.info("no return value for v1");
        });
        CompletableFuture<Void> v2 = CompletableFuture.runAsync(() ->{
            log.info("no return value for v2");
        });
        //allOf接收多个CompletableFuture无返回值任务；当所有的CompletableFuture任务执行结束后，返回一个新的CompletableFuture对象。
        //CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(v1, v2);
        CompletableFuture.allOf(v1, v2).join();//join()相当于实现了阻塞功能。
    }
    private static void anyOfDemo() {
        CompletableFuture<String> v1 = CompletableFuture.supplyAsync(() ->{
            return "no return value for v1";
        });
        CompletableFuture<String> v2 = CompletableFuture.supplyAsync(() ->{
            return "no return value for v2";
        });
        //上述两个带有返回值的CompletableFuture任务，其中一个执行完毕就会立刻返回。
        //thenAccept()是CompletionStage中提供的方法，这个方法用来获取前面的anyOf()方法中的执行结果来做更进一步的处理，
        // 其中value就是anyOf()方法中执行完成的任务的返回结果，可以理解为一种回调机制
        CompletableFuture.anyOf(v1, v2).thenAccept(value -> {log.info(value.toString());}).join();
    }
}
