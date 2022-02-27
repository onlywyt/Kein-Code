package com.example.logbackdemo.com.wangwenjun.concurrent.chapter10;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: source-demo
 * @description: 自定义类加载器测试
 * @ClassName：MyClassLoaderTest
 * @author: Mr.Wang
 * @create: 2022-02-25 11:01
 **/
public class MyClassLoaderTest {

    public static void main(String[] args) throws Exception {
       // MyClassLoader classLoader = new MyClassLoader(Paths.get("/Users/yingtaowang/Desktop/classloader1"),null);
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> aClass = classLoader.loadClass("com.example.logbackdemo.com.wangwenjun.concurrent.chapter10.Hello");
        System.out.println(aClass);

        Object helloWorld = aClass.newInstance();
        System.out.println("helloWorld:"+helloWorld);
        System.out.println("ClassLoader: "+helloWorld.getClass().getClassLoader());
        Method welocme = aClass.getMethod("welcome");
        String invoke = (String)welocme.invoke(helloWorld);
        System.out.println("Result:" + invoke);

    }
}
