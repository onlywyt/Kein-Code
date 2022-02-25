package com.example.logbackdemo.com.designmuster.单例;

/**
 * @program: source-demo
 * @description:
 * @ClassName：T
 * @author: Mr.Wang
 * @create: 2022-02-24 15:56
 **/
public class Test1  {
    private static Test1 t = null;
    private Test1() {}

    public static Test1 getinstance() {
        if (t == null) {
            t = new Test1();
        }
        return t;
    }
}
