package javaexample.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: source-demo
 * @description:
 * @ClassName：GeneralProxyDemo
 * @author: Mr.Wang
 * @create: 2022-03-14 11:11
 **/
public class GeneralProxyDemo {

    static interface IServiceA {
        void sayHello();
    }
    static class ServiceAImpl implements IServiceA {
        @Override
        public void sayHello() {
            System.out.println("ServiceA hello");
        }
    }
    static interface IServiceB {
        void fly();
    }

    static class ServiceImplB implements IServiceB {
        @Override
        public void fly() {
            System.out.println("ServiceB fly");
        }
    }

    //动态代理。利用getProxy方法获取代理对象，共享同样的代理逻辑。
    static class SimpleInvocationHandler implements InvocationHandler {
        private Object obj;

        public SimpleInvocationHandler(Object obj) {
            this.obj = obj;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering:" +  obj.getClass().getSimpleName() + "::" + method.getName());
            Object result = method.invoke(obj, args);
            System.out.println("leaving:" + obj.getClass().getSimpleName()+ "::" +method.getName());
            return result;
        }

        private static <T> T getProxy(Class<T> intf,T realObj){
            return (T) Proxy.newProxyInstance(intf.getClassLoader(),new Class[]{intf},new SimpleInvocationHandler(realObj));
        }

        public static void main(String[] args) {
            IServiceA a = new ServiceAImpl();
            IServiceA proxyA = getProxy(IServiceA.class, a);
            proxyA.sayHello();

            IServiceB b = new ServiceImplB();
            IServiceB proxyB = getProxy(IServiceB.class, b);
            proxyB.fly();

        }
    }

}

