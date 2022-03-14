package com.concurrent.source.thread.safety.threadlocaldemo;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.concurrent.source.thread.safety.Stu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description: 实现父子线程的本地变量完全隔离，子线程可复制父线程的本地变量
 * @ClassName：TransmittableThreadLocalDemo
 * @author: Mr.Wang
 * @create: 2022-03-14 15:45
 **/
public class TransmittableThreadLocalDemo {
    private static ThreadLocal<Stu> threadLocal = new MyTransmittableThreadLocal<>();
    public static ExecutorService executorService = TtlExecutors
            .getTtlExecutorService(Executors.newFixedThreadPool(1));
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开启");
        threadLocal.set(new Stu("1",1));
        System.out.println("主线程读取本地变量："+ threadLocal.get());

        executorService.submit(() ->{
            System.out.println("子线程读取本地变量：" + threadLocal.get());
        });
        TimeUnit.SECONDS.sleep(1);

        threadLocal.get().setAge(2);
        System.out.println("主线程读取本地变量：" + threadLocal.get());

        executorService.submit(() ->{
            System.out.println("子线程读取本地变量：" + threadLocal.get());//(读取到主线程修改后的值)
            threadLocal.get().setAge(3);
            System.out.println("子线程读取本地变量：" + threadLocal.get());
        });
        TimeUnit.SECONDS.sleep(1);
        System.out.println("主线程读取本地变量：" + threadLocal.get());

    }



}
