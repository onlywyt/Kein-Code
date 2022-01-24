package com.example.logbackdemo.com.test.source.thread;

/**
 * @program: source-demo
 * @description: 同步代码块导致多线程存在竞争CPU上下文切换频繁性能降低示例代码
 * @ClassName：ThreadConcurrentExample
 * @author: Mr.Wang
 * @create: 2022-01-18 16:12
 **/
public class ThreadConcurrentExample implements Runnable{

    private static final Long num = 1000000000L;
    private int sum;

    public ThreadConcurrentExample(int sum){
        this.sum = sum;
    }

    public static void runWithThread() throws InterruptedException{
        long startTime = System.currentTimeMillis();
        //执行两个任务
        //1.计算指定目标数的和
        int tempSum = 0;
        ThreadConcurrentExample tec = new ThreadConcurrentExample(tempSum);
        Thread thread = new Thread(tec);
        thread.start();
        int count = 0;
        for (int i = 0; i < num; i++) {
            count++;
        }
        thread.join();//确保线程结束
        long totalFree = System.currentTimeMillis() - startTime;
        System.out.println("runWithThread: totalFree = " + totalFree + ",+" + "count = " + count) ;
    }
    public static void runWithSerial() throws InterruptedException{
        long startTime = System.currentTimeMillis();
        //执行两个任务
        //1.计算指定目标数的和
        int tempSum = 0;
        for (int i = 0; i < num; i++) {
            tempSum+=i;
        }
        //同步计算遍历次数
        int counter = 0;
        for (int i = 0; i < num; i++) {
            counter++;
        }
        long totalFree = System.currentTimeMillis() - startTime;
        System.out.println("runWithSerial: totalFree= "+totalFree+",count= "+counter);

    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            synchronized (this){
                sum += i;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        runWithThread();
        runWithSerial();
    }
}
