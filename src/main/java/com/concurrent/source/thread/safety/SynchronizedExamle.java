package com.concurrent.source.thread.safety;

/**
 * @program: source-demo
 * @description: synchronized 类锁实例
 * @ClassName：SynchronizedExamloe
 * @author: Mr.Wang
 * @create: 2022-01-19 15:36
 **/
public class SynchronizedExamle {
    public void m1(){
        synchronized (SynchronizedExamle.class){
            while (true){
                System.out.println("当前线程：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //根据类锁的作用范围可以知道，即便是多个对象实例，也能够达到互斥的目的，因此最终输出的结果是：
    // 哪个线程抢到了锁，哪个线程就持续打印自己的线程名称
    public static void main(String[] args) {
        SynchronizedExamle synchronizedExamle1 = new SynchronizedExamle();
        SynchronizedExamle synchronizedExamle2 = new SynchronizedExamle();
        new Thread(()->synchronizedExamle1.m1(),"t1").start();
        new Thread(()->synchronizedExamle2.m1(),"t2").start();
    }
}
