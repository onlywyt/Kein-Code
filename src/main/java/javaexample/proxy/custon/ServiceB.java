package javaexample.proxy.custon;

import javaexample.proxy.annotation.SimpleSingleton;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ServiceB
 * @author: Mr.Wang
 * @create: 2022-03-14 14:12
 **/
@SimpleSingleton
public class ServiceB {
    public void action() {
        System.out.println("action");
    }
}
