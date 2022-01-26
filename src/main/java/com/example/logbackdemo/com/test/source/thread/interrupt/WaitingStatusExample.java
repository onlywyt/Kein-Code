package com.example.logbackdemo.com.test.source.thread.interrupt;

/**
 * @program: source-demo
 * @description: 等待状态实例 jps查看线程状态
 * @ClassName：WaitingStatusExample
 * @author: Mr.Wang
 * @create: 2022-01-18 12:18
 **/
public class WaitingStatusExample {
    public static void main(String[] args) {
        new Thread(() ->{
            synchronized (WaitingStatusExample.class){
                try {
                    WaitingStatusExample.class.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"WAITING").start();
    }
}
