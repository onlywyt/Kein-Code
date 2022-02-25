package com.example.logbackdemo.com.test.source.thread.threadpool.monitor;

import com.example.logbackdemo.com.test.source.thread.threadpool.ResizeLinkedBlockQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ThreadPoolForMonitorManager
 * @author: Mr.Wang
 * @create: 2022-01-24 22:32
 **/
@Component
public class ThreadPoolForMonitorManager {
    @Autowired
    ThreadPoolConfigurationProperties threadPoolProperties;

    private final ConcurrentMap<String,ThreadPoolExecutorMonitor> threadPoolMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        threadPoolProperties.getExecutors().forEach(threadPoolProperties->{
           if(!threadPoolMap.containsKey(threadPoolProperties.getPoolName())){
               ThreadPoolExecutorMonitor executorMonitor = new ThreadPoolExecutorMonitor(
                       threadPoolProperties.getCorePoolSize(),
                       threadPoolProperties.getMaximumPoolSize(),
                       threadPoolProperties.getKeepAliveTime(),
                       threadPoolProperties.getUnit(),
                       new ResizeLinkedBlockQueue<>(threadPoolProperties.getQueueCapacity()));
               threadPoolMap.put(threadPoolProperties.getPoolName(),executorMonitor);
           }
        });
    }

    public ThreadPoolExecutorMonitor getThreadPoolExecutorMonitor(String poolName){
        ThreadPoolExecutorMonitor threadPoolName = threadPoolMap.get(poolName);
        if(threadPoolName==null){
            throw new RuntimeException("找不到名字"+threadPoolName+"的线程池");
        }
        return threadPoolName;
    }

    public ConcurrentMap<String,ThreadPoolExecutorMonitor> getThreadPoolMap(){
        return this.threadPoolMap;
    }
}
