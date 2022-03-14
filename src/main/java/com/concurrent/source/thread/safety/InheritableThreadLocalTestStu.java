package com.concurrent.source.thread.safety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description:
 * @ClassName：InheritableThreadLocalTestStu
 * @author: Mr.Wang
 * @create: 2022-03-13 16:32
 **/
public class InheritableThreadLocalTestStu {

    private static ThreadLocal<Stu> threadLocal = new MyInheritableThreadLocal<>();
    public static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set(new Stu("1",1));
        executorService.submit(() ->{
            System.out.println("子线程读取本地变量：" + threadLocal.get());
            threadLocal.get().setAge(55);
            System.out.println("子线程读取本地变量：" + threadLocal.get());
        });
        TimeUnit.SECONDS.sleep(1);

        System.out.println("主线程读取本地变量:{读取到了子线程修改后的数据}：" + threadLocal.get() );
        threadLocal.get().setAge(99);
        System.out.println("主线程读取本地变量：" + threadLocal.get());

        executorService.submit(() ->{
            System.out.println("子线程读取本地变量(读取到主线程修改后的值)：" + threadLocal.get());
        });
    }
}
