package com.wangwenjun.concurrent.chapter10;

import java.nio.file.Paths;

/**
 * @program: source-demo
 * @description:
 * @ClassName：NameSpace
 * @author: Mr.Wang
 * @create: 2022-02-25 14:07
 **/
public class NameSpace {
    public static void main(String[] args) throws Exception  {
        demo2();

    }
    private static void demo2() throws ClassNotFoundException {
        //同一个类加载器的不同实例去加载同一个class文件，则会在堆内存和方法区产生多个class对象
        MyClassLoader classLoader = new MyClassLoader(Paths.get("/Users/yingtaowang/Desktop/classloader1"),null);
        MyClassLoader classLoader1 = new MyClassLoader(Paths.get("/Users/yingtaowang/Desktop/classloader1"),null);

        Class<?> aClass = classLoader.loadClass("com.example.logbackdemo.com.wangwenjun.concurrent.chapter10.Hello");
        Class<?> bClass = classLoader1.loadClass("com.example.logbackdemo.com.wangwenjun.concurrent.chapter10.Hello");

        System.out.println(aClass.getClassLoader());
        System.out.println(bClass.getClassLoader());

        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass == bClass);
    }


    private static void demo1() throws ClassNotFoundException {
        //获取系统类加载器
        ClassLoader classLoader = NameSpace.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("com.example.logbackdemo.com.wangwenjun.concurrent.chapter10.Hello");
        Class<?> bClass = classLoader.loadClass("com.example.logbackdemo.com.wangwenjun.concurrent.chapter10.Hello");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        //不论load多少次Hello，你都将会发现他们始终是同一份class对象
        System.out.println(aClass == bClass); //true
    }
}
