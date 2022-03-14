package com.concurrent.source.thread.safety.threadlocaldemo;

import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description: Threadlocal 存储的父线程的本地变量无法在子线程中获取demo
 * @ClassName：InheritableThreadLocalTest
 * @author: Mr.Wang
 * @create: 2022-03-13 16:22
 **/
public class InheritableThreadLocalTest {

    //public static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();//Threadlocal 存储的父线程的本地变量无法在子线程中获取demo

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set(123);
        System.out.println(threadLocal.get());
        //子线程
        new Thread(() -> System.out.println(threadLocal.get())).start();
        TimeUnit.SECONDS.sleep(1);
    }
}
