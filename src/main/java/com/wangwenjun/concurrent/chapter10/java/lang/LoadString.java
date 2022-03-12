package com.wangwenjun.concurrent.chapter10.java.lang;

import com.wangwenjun.concurrent.chapter10.BrokerDelegateClassLoader;

import java.nio.file.Paths;

/**
 * @program: source-demo
 * @description:  自定义类加载器中去掉java javax的前缀判断，运行加载自定义String类，报错 java.lang.NoClassDefFoundError
 * @ClassName：LoadString
 * @author: Mr.Wang
 * @create: 2022-02-28 15:34
 **/
public class LoadString {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        BrokerDelegateClassLoader classLoader = new BrokerDelegateClassLoader(Paths.get("/Users/yingtaowang/Desktop/classloader3"),null);
        Class<?> aClass = classLoader.loadClass("com.wangwenjun.concurrent.chapter10.java.lang.String");
        aClass.newInstance();
    }
}
