package com.example.logbackdemo.com.spring.evevt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @program: logbackdemo
 * @description: 全异步监听自定义事件
 * 注册了一个名称为AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME
 * （即applicationEventMulticaster）的Bean，
 * 用于覆盖默认的事件多播器，然后指定了TaskExecutor，SimpleAsyncTaskExecutor为Spring提供的异步任务executor。
 * @ClassName：AsyncEventVonfigure
 * @author: Mr.Wang
 * @create: 2022-01-16 17:04
 **/
@Component
public class AsyncEventVonfigure {
    @Bean(name = AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
    public ApplicationEventMulticaster simpleEventMulticaster(){
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }
}
