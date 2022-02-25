package com.example.logbackdemo.com.test.source.thread.safety;

import org.openjdk.jol.info.ClassLayout;

/**
 * @program: source-demo
 * @description:JOL（Java Object Layout）工具，查看对象内存布局
 * @ClassName：ClassLayoutExample
 * @author: Mr.Wang
 * @create: 2022-01-19 16:36
 **/
public class ClassLayoutExample {

    private int i;
    private  String string;

    public ClassLayoutExample(int i, String string) {
        this.i = i;
        this.string = string;
    }

    public static void main(String[] args) {
        ClassLayoutExample classLayoutExample = new ClassLayoutExample(1, "123");

        System.out.println(ClassLayout.parseInstance(classLayoutExample).toPrintable());
    }
}
