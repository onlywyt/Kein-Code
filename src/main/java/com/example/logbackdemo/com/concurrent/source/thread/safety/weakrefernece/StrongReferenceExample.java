package com.example.logbackdemo.com.test.source.thread.safety.weakrefernece;

/**
 * @program: source-demo
 * @description: Java中的强引用
 * @ClassName：StrongReferenceExample
 * @author: Mr.Wang
 * @create: 2022-01-21 13:08
 **/
public class StrongReferenceExample {
    static Object object = new Object();

    public static void main(String[] args) {
        Object strongReference = object;
        object=null;
        System.gc();
        System.out.println("gc之后：" + strongReference);
    }
}
