package com.example.logbackdemo.com.test.source.thread.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CreateThreaddemo1
 * @author: Mr.Wang
 * @create: 2022-01-18 11:50
 **/
@Slf4j
public class CreateThreaddemo1 implements Callable<String>  {

    /**
     *  Callable接口提供了一个带有返回值的call()方法，接着定义了一个FutureTask，来表示一个获取未来执行结果的任务，
     *  并使用Thread线程来执行，最后通过futureTask.get()方法来获得执行结果。
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThreaddemo1 createThreaddemo1 = new CreateThreaddemo1();
        FutureTask<String> futureTask = new FutureTask<>(createThreaddemo1);
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        log.info("result:{}",futureTask.get());
    }

    @Override
    public String call() throws Exception {
        return "SUCCESS";
    }
}
