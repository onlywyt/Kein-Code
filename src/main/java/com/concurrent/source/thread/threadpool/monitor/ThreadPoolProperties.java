package com.concurrent.source.thread.threadpool.monitor;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ThreadPoolProperties
 * @author: Mr.Wang
 * @create: 2022-01-24 22:26
 **/
@Data
public class ThreadPoolProperties {
    private String poolName;
    private int corePoolSize;
    private int maximumPoolSize=Runtime.getRuntime().availableProcessors();
    private long keepAliveTime=60;
    private TimeUnit unit=TimeUnit.SECONDS;
    private int queueCapacity=Integer.MAX_VALUE;

}
