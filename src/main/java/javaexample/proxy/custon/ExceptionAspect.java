package javaexample.proxy.custon;

import javaexample.proxy.annotation.Aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ExceptionAspect
 * @author: Mr.Wang
 * @create: 2022-03-14 14:08
 **/
@Aspect({ServiceB.class})
public class ExceptionAspect {

    public static void exceptionCaught(Object object,
                                       Method method,
                                       Object[] args,
                                       Throwable e){
        System.err.println("exception when calling: "
                + method.getName() + ","
                + Arrays.toString(args));
    }
}
