package com.concurrent.source.thread.threadpool.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ThreadPoolEndpoint
 * @author: Mr.Wang
 * @create: 2022-01-24 22:52
 **/
@Configuration
@Endpoint(id="thread-pool")
public class ThreadPoolEndpoint {
    @Autowired
    private ThreadPoolForMonitorManager threadPoolForMonitorManager;

    @ReadOperation
    public Map<String,Object> threadPoolsMetrics(){
        Map<String,Object> metricsMap = new HashMap<>();
        List<Map> threadPools = new ArrayList<>();

        threadPoolForMonitorManager.getThreadPoolMap().forEach((k,v)->{
            ThreadPoolExecutorMonitor tpe =  v;
            Map<String,Object> poolInfo = new HashMap<>();
            poolInfo.put("thread.pool",k);
            poolInfo.put("thread.pool.core.size",tpe.getCorePoolSize());
            poolInfo.put("thread.pool.largest.size",tpe.getMaximumPoolSize());
            poolInfo.put("thread.pool.thread.count",tpe.getPoolSize());
            poolInfo.put("thread.pool.min.costTime",tpe.getMinCostime());
            poolInfo.put("thread.pool.average.costTime",tpe.getActualCostime());
            poolInfo.put("thread.pool.max.costTime",tpe.getMaxCostime());
            poolInfo.put("thread.pool.active.count",tpe.getActiveCount());
            poolInfo.put("thread.pool.completed.taskCount",tpe.getCompletedTaskCount());
            poolInfo.put("thread.pool.queue.name",tpe.getQueue().getClass().getName());
            poolInfo.put("thread.pool.rejected.name",tpe.getRejectedExecutionHandler().getClass().getName());
            poolInfo.put("thread.pool.task.count",tpe.getTaskCount());
            threadPools.add(poolInfo);
        });
        metricsMap.put("threadPools",threadPools);
        return metricsMap;
    }
}
