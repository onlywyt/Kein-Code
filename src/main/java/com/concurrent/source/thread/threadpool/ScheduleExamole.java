package com.concurrent.source.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ScheduleExamole
 * @author: Mr.Wang
 * @create: 2022-01-23 16:25
 **/
public class ScheduleExamole {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(() ->{
            System.out.println("延迟三秒执行");
        },3, TimeUnit.SECONDS);
    }
}
