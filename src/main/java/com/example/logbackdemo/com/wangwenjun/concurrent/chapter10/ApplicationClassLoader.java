package com.example.logbackdemo.com.wangwenjun.concurrent.chapter10;

/**
 * @program: source-demo
 * @description: 　系统类加载器测试
 * @ClassName：ApplicationClassLoader
 * @author: Mr.Wang
 * @create: 2022-02-25 10:41
 **/
public class ApplicationClassLoader {
    public static void main(String[] args) {
        //获取系统类加载器加载资源的路径
        System.out.println(System.getProperty("java.class.path"));
        //系统类加载器是一种常见的类加载器，其负责加载classpath下的类库资源
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }
}
