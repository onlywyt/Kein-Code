package com.example.logbackdemo.com.wangwenjun.concurrent.chapter10;

/**
 * @program: source-demo
 * @description: 扩展类加载器ExtClassLoader测试
 * @ClassName：EtxClassLoaderDemo
 * @author: Mr.Wang
 * @create: 2022-02-25 10:35
 **/
public class ExtClassLoaderDemo {

    public static void main(String[] args) {
        //获取扩展类加载器加载资源的路径
        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
