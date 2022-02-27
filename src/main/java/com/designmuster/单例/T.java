package com.designmuster.单例;

/**
 * @program: source-demo
 * @description:
 * @ClassName：T
 * @author: Mr.Wang
 * @create: 2022-02-24 16:05
 **/
public class T
{
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ ":"+SingletonObject7.getInstance());
        }).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ ":"+SingletonObject7.getInstance());
        }).start();
    }
}
