package com.concurrent;

import java.util.Date;

/**
 * @program: spring-cloud-alibaba-provider
 * @description:
 * @ClassName：SuperTest
 * @author: Mr.Wang
 * @create: 2022-01-13 11:41
 **/

public class SuperTest extends Date {
    private static final long serialVersionUID = 1L;
    private void test(){
        /**
         *
         * 1.首先 super.getClass() 是父类的getClass（）方法，其父类是Date，
         * 它的getClass（）方法是继承自Object类而且没有重写，
         * 所以就是调用object的getClass（）方法。而看一下getclass的方法解释如下图
         * 所以可以知道是返回当前运行时的类。
         * 2.在调用getName()方法而getName()是：包名+类名
         */
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        new SuperTest().test();
    }
}
