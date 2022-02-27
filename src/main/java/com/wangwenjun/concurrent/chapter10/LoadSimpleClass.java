package com.wangwenjun.concurrent.chapter10;

import java.nio.file.Paths;

/**
 * @program: source-demo
 * @description:
 * @ClassName：LoadSimpleClass
 * @author: Mr.Wang
 * @create: 2022-02-27 22:21
 **/
public class LoadSimpleClass {

    public static void main(String[] args) throws Exception  {
        BrokerDelegateClassLoader classLoader = new BrokerDelegateClassLoader(Paths.get("/Users/yingtaowang/Desktop/classloader2"),null);
        Class<?> aClass = classLoader.loadClass("com.wangwenjun.concurrent.chapter10.SimpleClass");
        System.out.println(classLoader.getParent());
        aClass.newInstance();


    }
}
