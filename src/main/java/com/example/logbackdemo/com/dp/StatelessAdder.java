package com.example.logbackdemo.com.dp;

import com.example.logbackdemo.com.test.source.hashmapsource.ConcurrentHashMapDemo;

import java.util.Map;

/**
 * @program: source-demo
 * @description:
 * @ClassName：StatelessAdder
 * @author: Mr.Wang
 * @create: 2022-02-13 22:52
 **/
public class StatelessAdder {
    public static int adder(int a,int b){
        return a + b;
    }

    class Event{
        private int n = 0;
        public synchronized int add(){
            ++n;
            ++n;
            return n;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10000; i++) {
            MyThread1 myThread = new MyThread1(1,2);
            myThread.start();
            MyThread1 myThread1 = new MyThread1(2,3);
            myThread1.start();
        }
        System.out.println(System.identityHashCode("A"));
    }
    static class MyThread1 extends Thread {
        public int a;
        public int b;

        public MyThread1(int a,int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            System.out.println(adder(a, b));
        }
  }
}
