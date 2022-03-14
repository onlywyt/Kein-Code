package javaexample.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: source-demo
 * @description:
 * @ClassName：SimpleCGLibDemo
 * @author: Mr.Wang
 * @create: 2022-03-14 11:31
 **/
public class SimpleCGLibDemo {

    public static class RealService{
        public void sayHello(){
            System.out.println("CGLIB hello");
        }
    }

    static class SimpleInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o,
                                Method method,
                                Object[] objects,
                                MethodProxy methodProxy) throws Throwable {
            System.out.println("entering:" + method.getName());
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("leaving:" + method.getName());
            return result;
        }
    }

    private static <T> T getProxy(Class<T> clazz){
        Enhancer enhancer = new Enhancer();
        //使用了cglib的Enhancer类。Enhancer类的setSuperclass设置被代理的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new SimpleInterceptor());
        return (T) enhancer.create();
    }

    public static void main(String[] args) throws Exception  {
        RealService proxy = getProxy(RealService.class);
        proxy.sayHello();
    }
}
