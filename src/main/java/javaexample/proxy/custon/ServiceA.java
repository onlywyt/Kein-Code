package javaexample.proxy.custon;

import javaexample.proxy.annotation.SimpleInject;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ServiceA
 * @author: Mr.Wang
 * @create: 2022-03-14 14:11
 **/
public class ServiceA {

    @SimpleInject
    ServiceB b;
    public void callB() {
        b.action();
    }

    public ServiceB getB() {
        return b;
    }

}
