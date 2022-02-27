package com.concurrent.source.thread.interrupt;

/**
 * @program: source-demo
 * @description: 守护线程示例
 * @ClassName：DeamonThradExample
 * @author: Mr.Wang
 * @create: 2022-01-18 17:15
 **/
public class NotDeamonThreadExample {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(() ->{
            while (true){
                try {
                    System.out.println("用户线程运行中.....");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("主线程执行完毕。。。。");//可以发现即便main()方法运行结束，该JVM进程也是处于存活状态；可以发现即便main()方法运行结束，该JVM进程也是处于存活状态
    }
}
