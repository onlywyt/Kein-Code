package com.wangwenjun.concurrent.chapter11;

import static java.lang.Thread.currentThread;

/**
 * @program: source-demo
 * @description: 线程上下文类加载器
 * @ClassName：MainThreadClasLoader
 * @author: Mr.Wang
 * @create: 2022-02-28 15:57
 **/
public class MainThreadClasLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * JDK定义了SPI的标准接口，加之这些接口被作为JDK核心标准类库的一部分，既想完全透明标准接口的实现，
         * 又想与JDK核心库进行捆绑，由于JVM类加载器双亲委托机制的限制，
         * 启动类加载器不可能加载得到第三方厂商提供的具体实现。
         * 为了解决这个困境，JDK只好提供一种不太优雅的设计——线程上下文类加载器，
         * 有了线程上文类加载器，启动类加载器（根加载器）反倒需要委托子类加载器去加载厂商提供的SPI具体实现。
         */
        System.out.println(currentThread().getContextClassLoader());
    }
}
