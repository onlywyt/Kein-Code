package javaexample.proxy.custon;

import javaexample.proxy.annotation.Aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ServiceLogAspect
 * @author: Mr.Wang
 * @create: 2022-03-14 14:03
 **/
@Aspect({ServiceA.class,ServiceB.class})
public class ServiceLogAspect {
    public static void before(Object object, Method method,Object[] args){
        System.out.println("entering:"
                + method.getDeclaringClass().getSimpleName()
                + ": :"
                + method.getName()
                + ", args:"
                + Arrays.toString(args));
    }

    public static void after(Object object, Method method,Object[] args, Object result) {
        System.out.println("leaving:"
                + method.getDeclaringClass().getSimpleName()
                + ": : "
                + method.getName()
                + ", result : "
                + result);

    }
}
