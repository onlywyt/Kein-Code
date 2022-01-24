package com.example.logbackdemo.com.test.source.thread.safety.deadlock.brokedeaadlock;

import com.example.logbackdemo.com.test.source.thread.safety.deadlock.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: source-demo
 * @description: 统一锁资源申请类,当前涉及的相关资源都实现了一个统一的锁资源获取和释放，从而打破了请求和保持条件。不会导致死锁
 * @ClassName：ApplyLock
 * @author: Mr.Wang
 * @create: 2022-01-20 09:57
 **/
public class ApplyLock {
    private List<Object> listOf = new ArrayList<>();

    public synchronized boolean applyLock(Resource resource1,Resource resource2){
        if (listOf.contains(resource1) || listOf.contains(resource2)){
            return false;
        }else {
            listOf.add(resource1);
            listOf.add(resource2);
            return true;
        }
    }

    public synchronized void freeListOf(Resource resource1,Resource resource2){
        listOf.remove(resource1);
        listOf.remove(resource2);
    }
}
