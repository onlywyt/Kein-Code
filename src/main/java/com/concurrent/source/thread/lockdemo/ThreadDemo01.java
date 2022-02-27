package com.concurrent.source.thread.lockdemo;

/**
 * @program: source-demo
 * @description: 多线程环境下的售票问题，synchronized关键字确保并发安全
 * @ClassName：ThreadDemo01
 * @author: Mr.Wang
 * @create: 2022-02-22 15:36
 **/
public class ThreadDemo01 implements Runnable {

    private int tickets = 100;
    @Override
    public void run() {
        while (true) {
            sellTickets();
        }
    }

    private synchronized void sellTickets() {
        if (tickets > 0){
            System.out.println(Thread.currentThread().getName() + tickets);
            tickets--;
        }
    }

    public static void main(String[] args) {
        ThreadDemo01 t = new ThreadDemo01();
        Thread thread0 = new Thread(t);
        Thread thread1 = new Thread(t);
        thread1.setName("售票点1: ");
        thread0.setName("售票点0: ");
        thread1.start();
        thread0.start();
    }
}
