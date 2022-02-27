package com.designmuster.单例;

/**
 * @program: source-demo
 * @description:
 * @ClassName：Singleton
 * @author: Mr.Wang
 * @create: 2022-02-27 10:06
 **/
public class Singleton {
    //私有化构造方法
    private Singleton() {};

    //私有方法获取单例实例
    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }

    //调用Singleton.getInstance程序访问 LazyHolder.INSTANCE，触发对 LazyHolder 的初始化,新建一个 Singleton 的实例(多线程安全)
    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
