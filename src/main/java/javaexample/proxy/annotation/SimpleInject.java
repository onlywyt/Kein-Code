package javaexample.proxy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @program: source-demo
 * @description:
 * @ClassName：SimpleInject
 * @author: Mr.Wang
 * @create: 2022-03-14 14:13
 **/
@Retention(RUNTIME)
@Target(FIELD)
public @interface SimpleInject {
}
