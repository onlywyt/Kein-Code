package com.concurrent.source.hashmapsource;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-cloud-alibaba-provider
 * @description:
 * @ClassName：HashMapThread
 * @author: Mr.Wang
 * @create: 2022-01-13 16:22
 **/
public class HashMapThread {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            MyThread myThread = new MyThread(map, "线程名字1：" + i);
            myThread.start();
            MyThread myThread1 = new MyThread(map, "线程名字2：" + i);
            myThread1.start();
        }
        System.out.println("map size is: " + map.size());
    }

    static class MyThread extends Thread {
        public Map map;
        public String name;

        public MyThread(Map map, String name) {
            this.map = map;
            this.name = name;
        }


        @Override
        public void run() {
            double i = Math.random() * 100000;
            map.put("键" + i, "值" + i);
            map.remove("键" + i);
        }
    }

}
