package com.example.logbackdemo.com.test.source.thread.safety;

/**
 * @program: source-demo
 * @description: i++ 线程不安全实例。不能保证原子性
 * 代码中启动了两个线程，每个线程对成员变量i累加10000次，然后打印出累加后的结果。
 * 我们从结果中发现，原本期望的值是20000，但是打印出来的i值都是一个小于20000的数，和预期的结果不一致，导致这个现象产生的原因就是原子性问题。
 * @ClassName：AtomicExample
 * @author: Mr.Wang
 * @create: 2022-01-18 18:20
 **/
public class AtomicExample {
    volatile int i =0;
    public synchronized void incr(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException{
        AtomicExample example = new AtomicExample();
        Thread[] threads=new Thread[2];
        for (int i = 0; i < 2; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    example.incr();
                }
            });
            threads[i].start();
        }
        threads[0].join();
        threads[1].join();
        System.out.println(example.i);
    }
}
