package com.concurrent.source.Async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CompleteMethodDemo
 * @author: Mr.Wang
 * @create: 2022-02-09 18:34
 **/
@Slf4j
public class CompleteMethodDemo {
    public static void main(String[] args) {
        CompletableFuture completableFuture = new CompletableFuture();
        new Thread(new ClientThread(completableFuture)).start();
        new Thread(new ClientThread(completableFuture)).start();
        log.info("两个客户端线程被get阻塞");
        completableFuture.complete("finish");//线程会被唤醒
    }

    /**
     * 在线程中使用completableFuture.get()获取返回值，此时CompletableFuture并没有使用前面提到的runAsync()等方法构建异步任务，
     * 所以get()方法必然会阻塞。接着在代码中使用complete("finish")来完成任务的计算，
     * 并且返回的结果是finish。由于此时CompletableFuture有了返回值，
     * 因此被阻塞的两个ClientThread会被唤醒。从使用方法来看，complete()方法相当于实现了线程之间的数据通信功能。
     */
    static class ClientThread implements Runnable{
        private CompletableFuture completableFuture;
        public ClientThread(CompletableFuture completableFuture){
            this.completableFuture = completableFuture;
        }
        @SneakyThrows
        @Override
        public void run() {
            log.info(Thread.currentThread().getName() + " : " +completableFuture.get());//线程会阻塞。因为没有使用异步构建任务
        }
    }
}
