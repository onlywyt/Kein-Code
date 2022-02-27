package com.concurrent.source.thread.safety.weakrefernece;

import java.lang.ref.WeakReference;

/**
 * @program: source-demo
 * @description: Java中的弱引用
 *  在ThreadLocal中，如果ThreadLocal对象被回收了，那么在ThreadLocalMap中key的引用就会为空，因为这里用到了弱引用。
 *  从理论上来说，如果在强引用的情况下，这时候是不可能被回收的，因为weakReference引用了weakObject对象，但实际上，
 *   当object被设置为null时，它被回收后，objectWeakReference.get()得到的结果也是null。
 * @ClassName：WeakReferenceExample
 * @author: Mr.Wang
 * @create: 2022-01-21 13:06
 **/
public class WeakReferenceExample {

    static Object object = new Object();

    public static void main(String[] args) {
        WeakReference<Object> objectWeakReference = new WeakReference<>(object);
        object=null;
        System.gc();
        System.out.println("gc之后：" + objectWeakReference.get());
    }



}
