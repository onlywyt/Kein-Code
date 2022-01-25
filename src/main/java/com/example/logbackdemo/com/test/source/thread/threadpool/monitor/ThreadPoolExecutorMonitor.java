package com.example.logbackdemo.com.test.source.thread.threadpool.monitor;

import com.example.logbackdemo.com.test.source.thread.threadpool.ResizeLinkedBlockQueue;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 * @program: source-demo
 * @description:
 * @ClassName：ThreadPoolExecutorMonitor
 * @author: Mr.Wang
 * @create: 2022-01-24 18:04
 **/
public class ThreadPoolExecutorMonitor extends ThreadPoolExecutor {

    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();

    private static final String defaultPoolName = "Default-Task";

    private static ThreadFactory factory = new MonitorThreadFactory(defaultPoolName);

    public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    private long minCostime;
    private long maxCostime;
    private AtomicLong totalCount = new AtomicLong();
    private ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();



    @Override
    public void shutdown() {
        super.shutdown();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTimeThreadLocal.set(System.currentTimeMillis());
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        long costTime = System.currentTimeMillis() - startTimeThreadLocal.get();
        startTimeThreadLocal.remove();
        maxCostime=maxCostime>costTime?maxCostime:costTime;
        if(getCompletedTaskCount()==0){
            minCostime=costTime;
        }
        minCostime=minCostime<costTime?maxCostime:costTime;
        totalCount.addAndGet(costTime);
        super.afterExecute(r, t);
    }

    public long getMinCostime(){
        return minCostime;
    }
    public long getMaxCostime(){
        return maxCostime;
    }


    public long getActualCostime(){
        if(getCompletedTaskCount()==0 || totalCount.get()==0){
            return 0;
        }
        return totalCount.get()/getCompletedTaskCount();
    }

    @Override
    protected void terminated() {
        super.terminated();
    }

    static class MonitorThreadFactory implements ThreadFactory {

        private final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MonitorThreadFactory(String poolName){
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup():Thread.currentThread().getThreadGroup();
            namePrefix = poolName + "-pool-" + poolNumber.getAndIncrement()+"-thread-";

        }

        MonitorThreadFactory(ThreadGroup group, String namePrefix) {
            this.group = group;
            this.namePrefix = namePrefix;
        }


        @Override
        public Thread newThread(Runnable r) {
            Runnable target;
            Thread t = new Thread(group, r,namePrefix + threadNumber.getAndIncrement(),0);
            if(t.isDaemon()){
                t.setDaemon(false);
            }
            if(t.getPriority() != Thread.NORM_PRIORITY){
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }
}
