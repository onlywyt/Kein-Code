package com.concurrent.source.thread.juc.action;

import java.util.concurrent.CountDownLatch;

/**
 * @program: source-demo
 * @description: 未完成的demo
 * @ClassName：BashHealthChecker
 * @author: Mr.Wang
 * @create: 2022-02-11 13:23
 **/
public abstract class BashHealthChecker implements Runnable {
    private CountDownLatch latch; //定时器
    private String serviceName;   //服务名称
    private boolean serviceUp;     //判断服务是否启动

    public BashHealthChecker(CountDownLatch latch, String serviceName){
        this.latch = latch;
        this.serviceName = serviceName;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            if(latch!= null) {
                latch.countDown();
            }
        }
    }

    protected abstract void verifyService();
}
