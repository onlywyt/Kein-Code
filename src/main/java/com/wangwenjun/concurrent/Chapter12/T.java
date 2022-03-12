package com.wangwenjun.concurrent.Chapter12;

import java.lang.reflect.Field;

/**
 * @program: source-demo
 * @description:
 * @ClassName：T
 * @author: Mr.Wang
 * @create: 2022-02-28 17:23
 **/
public class T {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field myCache = cache.getDeclaredField("cache");
        myCache.setAccessible(true);
        Integer[] newCache = (Integer[]) myCache.get(cache);
        newCache[132] = newCache[134];
        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);

        System.out.println("最大取值：" + Integer.MAX_VALUE);
        System.out.println("最小取值：" + Integer.MIN_VALUE);
    }


}
