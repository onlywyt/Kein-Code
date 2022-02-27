package com.concurrent.source.nettyaction.Chapter6;

import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description: 通过注册JDK的ShutdownHook来实现优雅停机
 * @ClassName：ShutdownHookDemo
 * @author: Mr.Wang
 * @create: 2022-02-17 13:52
 **/
public class ShutdownHookDemo {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(System.getProperties().getProperty("os.name"));//获取当前操作系统名称
//        String mac = System.getProperties().getProperty("os.name").toLowerCase().startsWith("mac") ? "INT" : "TERM";
//        Signal signal = new Signal(mac);

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Shutdown execute start ...");
            System.out.println("Netty NioeventLoogGroup shutdownGracefully...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
             e.printStackTrace();
            }
            System.out.println("ShutdownHook execute end...");
        },"t1"));
        TimeUnit.SECONDS.sleep(5);
        System.exit(0);
    }


}
