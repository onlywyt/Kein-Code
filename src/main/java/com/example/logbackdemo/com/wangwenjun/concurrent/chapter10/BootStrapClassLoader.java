package com.example.logbackdemo.com.wangwenjun.concurrent.chapter10;

/**
 * @program: source-demo
 * @description: 根加载器测试
 * @ClassName：BootStrapClassLoader
 * @author: Mr.Wang
 * @create: 2022-02-25 10:32
 **/
public class BootStrapClassLoader {

    public static void main(String[] args) {
        //String.class的类加载器是根加载器，根加载器是获取不到引用的，因此输出为null
        System.out.println("BootStrap: " + String.class.getClassLoader());
        //根加载器所在的加载路径可以通过sun.boot.class.path这个系统属性来获得
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
