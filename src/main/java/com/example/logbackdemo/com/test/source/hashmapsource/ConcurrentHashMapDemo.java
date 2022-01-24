package com.example.logbackdemo.com.test.source.hashmapsource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
     上述代码在多线程并发调用时，会存在线程安全性问题，
     虽然ConcurrentHashMap对于数据操作本身是安全的，
     但是在上述代码中是一个复合操作，也就是“读—修改—写”，
     而这三个操作不是原子的，所以当多个线程访问同一个用户mic时，
     很可能会覆盖相互操作的结果，造成记录的次数少于实际次数。
 **/
public class ConcurrentHashMapDemo {
    private static final ConcurrentMap<String, Long> USER_ACCESS_COUNT = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            MyThread1 myThread = new MyThread1(USER_ACCESS_COUNT,"mic");
            myThread.start();
            MyThread1 myThread1 = new MyThread1(USER_ACCESS_COUNT,"mic");
            myThread1.start();
        }
    }

    /**
     * ConcurrentHashMap是线程安全的，但是对于ConcurrentHashMap的复合操作，
     * 我们需要特别关注。当然，上述问题其实有很多种解决方案，比如我们针对这个复合操作进行加锁。
     * ConcurrentHashMap提供了另外一个解决方案，就是使用ConcurrentMap接口定义。
     * ConcurrentMap是一个支持并发访问的Map集合，相当于在原本的Map集合上新增了一些方法来扩展原有Map的功能，
     * 而ConcurrentHashMap实现了ConcurrentMap接口。
     */
    static class MyThread1 extends Thread {

        public Map map;
        public String name;

        public MyThread1(Map map, String name) {
            this.map = map;
            this.name = name;
        }

        @Override
        public void run() {
            while (true){
                Long accessCount = USER_ACCESS_COUNT.get("mic");
                if (accessCount==null){
                    Long mic = USER_ACCESS_COUNT.putIfAbsent("mic", 1L);
                    if (mic == null){
                        System.out.println(accessCount);
                        break;
                    }
                }else {
                    if (USER_ACCESS_COUNT.replace("mic",accessCount,accessCount+1)){
                        System.out.println(accessCount);
                        break;
                    }
                 }
                System.out.println(accessCount);
            }

         }
    }
}
