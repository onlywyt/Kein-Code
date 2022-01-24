package com.example.logbackdemo.com.spring.evevt;

import com.example.logbackdemo.LogbackdemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.stereotype.Component;

/**
 * @program: logbackdemo
 * @description: 自定义一个事件发布器MyEventPublisher,实现事件发布器接口ApplicationEventPublisherAware
 * @ClassName：MyEventPublisher
 * @author: Mr.Wang
 * @create: 2022-01-16 16:36
 **/
@Component
public class MyEventPublisher implements ApplicationEventPublisherAware, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(MyEventPublisher.class);


    private ApplicationContext applicationContext;
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }



    public void publishEvent() {
        logger.info("开始发布自定义事件MyEvent");
        MyEvent myEvent = new MyEvent(applicationContext);
        applicationEventPublisher.publishEvent(myEvent);
        logger.info("自定义事件myevent发布完成");
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
