package javaexample.proxy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @program: source-demo
 * @description:
 * @ClassName：SimpleSingleton
 * @author: Mr.Wang
 * @create: 2022-03-14 14:29
 **/
@Retention(RUNTIME)
@Target(TYPE)
public @interface SimpleSingleton {
}
