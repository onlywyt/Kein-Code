package com.concurrent;

import java.util.HashMap;

/**
 * @program: spring-cloud-alibaba-provider
 * @description: 多线程环境hashMap不安全
 * @ClassName：HashMapInfiniteLoop
 * @author: Mr.Wang
 * @create: 2022-01-13 16:15
 **/
public class HashMapInfiniteLoop {

    //map初始化为一个长度为2的数组，loadFactor=0.75，threshold=2*0.75=1，也就是说当put第二个key的时候，map就需要进行resize。
    private static HashMap<Integer, String> map = new HashMap<>(2,0.75f);

    public static void main(String[] args) {
        map.put(5,"A");
        new Thread("Thread1"){
            @Override
            public void run() {
                map.put(7,"b");
                System.out.println(map);
            }
        }.start();
        new Thread("Thread2"){
            @Override
            public void run() {
                map.put(3,"C");
                System.out.println(map);
            }
        }.start();
    }
}
