package com.example.logbackdemo.com.test.source.thread.pvolatile;

import sun.misc.Contended;

/**
 * @program: source-demo
 * @description: 通过创建多个线程并对共享对象的值进行修改，来模拟伪共享的问题
 * @ClassName：FalseSharingExample
 * @author: Mr.Wang
 * @create: 2022-01-25 15:36
 **/
public class FalseSharingExample implements Runnable  {

    @Contended
    public static final long ITERATIONS = 500L * 1000L * 100L;
    private int arrayindex = 0;
    private static ValuePadding[] longs;

    public FalseSharingExample(int arrayindex) {
        this.arrayindex = arrayindex;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10; i++) {
            System.gc();
            final long stat = System.currentTimeMillis();
            runTest(i);
            System.out.println(i + " Threads,duration = " + (System.currentTimeMillis() - stat));
            
        }
    }

    private static void runTest(int  NUM_THREADS) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        longs = new ValuePadding[NUM_THREADS];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new ValuePadding();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharingExample(i));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i){
            longs[arrayindex].value = 0L;
        }
    }

    public final static class ValuePadding{
        protected long p1,p2,p3,p4,p5,p6,p7;//前置填充
        protected volatile long value = 0L;
        protected long p9, p10, p11, p12, p13, p14, p15; //后置填充
    }

    public final static class ValueNoPadding{
        protected volatile long value = 0L;
    }
}
