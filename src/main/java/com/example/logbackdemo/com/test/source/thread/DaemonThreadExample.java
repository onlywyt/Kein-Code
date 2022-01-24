package com.example.logbackdemo.com.test.source.thread;

/**
 * @program: source-demo
 * @description:
 * @ClassName：DaemonThreadExample
 * @author: Mr.Wang
 * @create: 2022-01-18 17:19
 **/
public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException{
        //Runtime.getRuntime().addShutdownHook()可以用来注册JVM关闭的钩子，这个钩子可以在程序正常退出、系统关闭、OOM宕机时被回调
        Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("JVM进程已结束")));
        Thread thread = new Thread(()->{
           while (true){
               System.out.println("用户线程执行中。。。。");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
        System.out.println("主线程执行完毕。。。。");
    }
}
