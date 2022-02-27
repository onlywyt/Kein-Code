package com.concurrent.source.arraylistsource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: logbackdemo
 * @description:
 * @ClassName：IteratorDemo
 * @author: Mr.Wang
 * @create: 2022-01-16 23:01
 **/
public class IteratorDemo {
    private static List<String> list = new ArrayList<>();

    public static void test(){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("123");
        Iterator<String> iterator = list.iterator();
        list.add("ABC");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    public static void main(String[] args) {
        test();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iter = list.iterator();

        // 存放10个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 执行10个任务(我当前正在迭代集合（这里模拟并发中读取某一list的场景）)
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
            });
        }

        // 执行10个任务
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    list.add("121");// 添加数据
                }
            });
        }

        System.err.println(Arrays.toString(list.toArray()));

    }

}
