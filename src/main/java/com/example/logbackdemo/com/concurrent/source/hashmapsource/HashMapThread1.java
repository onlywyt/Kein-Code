package com.example.logbackdemo.com.test.source.hashmapsource;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-cloud-alibaba-provider
 * @description:
 * @ClassName：HashMapThread
 * @author: Mr.Wang
 * @create: 2022-01-13 16:22
 **/
public class HashMapThread1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int j = 0; j < 100; j++) {
            double i = Math.random() * 100000;
            map.put("键" + i, "值" + i);
            map.remove("键" + i);
            System.out.println(i);
        }
        System.out.println("map size is: " + map.size());
    }
}
