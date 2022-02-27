package com.designmuster.单例;

/**
 * @program: source-demo
 * @description:
 * @ClassName：Test2
 * @author: Mr.Wang
 * @create: 2022-02-24 16:02
 **/
public class Test2 {

    private static Test2 t = null;
    private Test2() {}

    public static Test2 getInstance() {
        if (t == null) {
            synchronized (Test2.class) {
                if (t == null) {
                    t = new Test2();
                }
            }
        }
        return t;
    }
}
