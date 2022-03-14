package javaexample.proxy.DI;

import javaexample.proxy.custon.ServiceA;

/**
 * @program: source-demo
 * @description:
 * @ClassName：Test
 * @author: Mr.Wang
 * @create: 2022-03-14 14:24
 **/
public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ServiceA instance = CGLibContainer2.getInstance(ServiceA.class);
        instance.callB();
    }
}
