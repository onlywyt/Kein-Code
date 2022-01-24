package com.example.logbackdemo.com.test.source.thread.safety.deadlock;

import com.example.logbackdemo.com.test.source.thread.safety.deadlock.brokedeaadlock.ApplyLock;

/**
 * @program: source-demo
 * @description: 资源类。用来测试死锁
 * @ClassName：Resource
 * @author: Mr.Wang
 * @create: 2022-01-19 17:03
 **/
public class Resource {
    static ApplyLock applyLock=new ApplyLock();

    private String name;
    private int count;

    public Resource(String name) {
        this.name = name;
    }

    public void statisticsResource(){
        synchronized (this){
            System.out.println("statistics resource");
            count++;
            System.out.println(count);
        }
    }
    public void saveResource(Resource resource){
        applyLock.applyLock(this,resource);
        try {
            System.out.println("save resource");
            resource.statisticsResource();
        } finally {
            applyLock.applyLock(this,resource);
        }

    }

}
