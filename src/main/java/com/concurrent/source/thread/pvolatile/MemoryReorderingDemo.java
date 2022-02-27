package com.concurrent.source.thread.pvolatile;

/**
 * @program: source-demo
 * @description:   指令重排序导致最终运行结果会出现误差
 * @ClassName：MemoryReorderingDemo
 * @author: Mr.Wang
 * @create: 2022-01-25 16:42
 **/
public class MemoryReorderingDemo {

    private static int x=0,y=0;
    private static int a=0,b=0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true){
            i++;
            x=0;y=0;
            a=0;b=0;
            Thread t1=new Thread(()->{
                a=1;
                x=b;
            });
            Thread t2=new Thread(()->{
               b=1;
               y=a;
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            String result="第"+i+"次("+x+","+y+")";
            if(x==0 && y==0){
                System.out.println(result);
                break;
            }
        }
    }
}
