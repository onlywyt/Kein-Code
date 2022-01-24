package com.example.logbackdemo.com.test.source.thread.safety;

/**
 * @program: source-demo
 * @description: 对象锁，互斥，实例
 * @ClassName：SynchronizedForObjectExample
 * @author: Mr.Wang
 * @create: 2022-01-19 15:42
 **/
public class SynchronizedForObjectExample {
    static Object lock = new Object();//如果去掉static那么synchronized就会失去作用；
    // 因为每个SynchronizedForObjectExample对象都会创建一个Object
    public void m1(){
        synchronized (lock){
            while (true){
                System.out.println("当前获取的锁的线程：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
//不同的SynchronizedForObjectExample实例会有不同的lock锁对象，由于没有形成竞争，所以不会实现互斥的效果。
    public static void main(String[] args) {
        SynchronizedForObjectExample se1 = new SynchronizedForObjectExample();
        SynchronizedForObjectExample se2 = new SynchronizedForObjectExample();
        new Thread(() -> se1.m1(),"s1").start();
        new Thread(() -> se2.m1(),"s2").start();
    }
}
