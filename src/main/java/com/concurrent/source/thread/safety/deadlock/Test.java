package com.concurrent.source.thread.safety.deadlock;

/**
 * @program: source-demo
 * @description:
 * @ClassName：Test
 * @author: Mr.Wang
 * @create: 2022-02-14 13:55
 **/
public class Test {
    private int a=0;
    private long b=0;
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            Test test = new Test();
            new Thread(() -> {
                test.set();
                System.out.println(test.check());
            }).start();
            new Thread(() -> {
                System.out.println(test.check());
                test.set();

            }).start();
        }
    }
    void set(){
        a = 1;
        b = -1;
    }
    boolean check(){
        return ((b == 0)||(b ==-1 && a == 1));
    }

}
