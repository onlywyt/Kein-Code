package com.wangwenjun.concurrent.Chapter12;

import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description:
 * @ClassName：VolatileDemo
 * @author: Mr.Wang
 * @create: 2022-02-28 16:13
 **/
public class VolatileDemo {

    //init_value 最大值
    final static int MAX = 5;
    //init_value初始值;不加volatile
    static volatile int  init_value = 0;

    public static void main(String[] args) {
        //启动一个Reader线程，当发现local_value和init_value不同时，则输出init_value被修改的信息
        new Thread(() ->{
            int localValue = init_value;// 0
            while (localValue < MAX){// <5
                if (init_value != localValue){
                    System.out.printf("The inti_value is update to [%d]\n", init_value);
                    localValue = init_value;
                }
            }
        },"Reader").start();

        new Thread(() ->{
            int localValue = init_value;
            while (localValue < MAX){
                //修改init_valve
                System.out.printf("The init_value will be change to [%d]\n", ++localValue);
                init_value = localValue;
                try {
                    //短暂休眠，目的是为了使Reader线程能够有时间输出变化内容
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"Update").start();
    }

}
