package com.example.logbackdemo.com.designmuster.单例;

/**
 * @program: source-demo
 * @description: 饿汉单例
 * @ClassName：Test
 * @author: Mr.Wang
 * @create: 2022-02-24 15:56
 **/
public class Test {

    private static Test test = new Test();

    private Test(){
    }

    public static Test getInstance(){
        return test;
    }

}
