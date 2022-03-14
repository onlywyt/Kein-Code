package javaexample.proxy.annotation;

/**
 * @program: source-demo
 * @description:
 * @ClassName：Aspect
 * @author: Mr.Wang
 * @create: 2022-03-14 13:59
 **/

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
public @interface Aspect {
    //可以指定要增强的类
    Class<?>[] value();
}
