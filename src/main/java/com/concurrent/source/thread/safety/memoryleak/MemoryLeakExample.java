package com.concurrent.source.thread.safety.memoryleak;

import java.util.concurrent.*;

/**
 * @program: source-demo
 * @description:
 * @ClassName：MemoryLeakExample
 * @author: Mr.Wang
 * @create: 2022-01-21 13:54
 **/
public class MemoryLeakExample {
    static class LocalVariable{
        private Long[] data = new Long[1024*1024];
    }

    TimeUnit unit;
    BlockingQueue workQueue;
    static ThreadPoolExecutor service=new ThreadPoolExecutor(5, 5,
            60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    static ThreadLocal local = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(8);//延迟启动
        CountDownLatch countDownLatch = new CountDownLatch(50);
        for (int i = 0; i < 50; i++) {
            service.execute(()->{
                local.set(new LocalVariable());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                     e.printStackTrace();
                }
                //local.remove();//移除当前线程存储的value
                //由于我们把local这个对象置为null并且触发了gc回收，在没有调用remove()方法的场景中，大概有20MB左右的内存没有办法被回收，这部分内存永远无法被释放，除非线程池中的所有线程都被回收。
                //因此，总的来说，在使用ThreadLocal的地方，每个线程用完后，最终需要调用remove()方法防止出现内存泄漏。
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        local=null;
        System.gc();
        System.out.println(local);

    }

}
