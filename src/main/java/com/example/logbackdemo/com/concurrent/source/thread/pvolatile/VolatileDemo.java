package com.example.logbackdemo.com.test.source.thread.pvolatile;

/**
 * @program: source-demo
 * @description: 主线程修改变量但是线程t无法获取变量值
 * @ClassName：VolatileDemo
 * @author: Mr.Wang
 * @create: 2022-01-25 11:17
 **/
public class VolatileDemo {
    public volatile static boolean stop=false;//去掉volatile则变量值不可见；volatile可以禁止编译器的优化，在多处理器环境下保证共享变量的可见性。
    //可见性 BGM:hidden path 场记单？
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() ->{
            int i= 0;
            while (!stop){
                i++;
            }
        });
        t.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop=true;

    }
}
