package com.concurrent.source.thread.safety.deadlock;


import com.concurrent.source.thread.safety.deadlock.brokedeaadlock.Resource1;

/**
 * @program: source-demo
 * @description:
 * @ClassName：DeadlockExample
 * @author: Mr.Wang
 * @create: 2022-01-19 17:03
 **/
public class DeadlockExample {

    /**
     两个线程分别访问两个不同的Resource对象，每个resource对象分别调用saveResource()方法保存resource对象的资源，
     这必然会导致死锁问题。由于两个线程持有自己的对象锁资源，
     在saveResource()方法中访问对方的statisticsResource()方法并占用对方的锁资源，所以产生互相等待造成死锁的现象。
     * @param args
     */
    public static void main(String[] args) {
        Resource1 resource1 = new Resource1("resource1");
        Resource1 resource2 = new Resource1("resource2");
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 100; i++) {
                resource1.saveResource(resource2);
            }
        });
        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 100; i++) {
                resource2.saveResource(resource1);
            }
        });
        t1.start();
        t2.start();
    }
}
