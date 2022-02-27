package com.spring.evevt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: logbackdemo
 * @description: 编程实现监听类、手动实现ApplicationListener接口实现事件监听
 * @ClassName：MyEventListener
 * @author: Mr.Wang
 * @create: 2022-01-16 17:09
 **/
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    private static final Logger logger = LoggerFactory.getLogger(MyEventListener.class);


    @Override
    public void onApplicationEvent(MyEvent event) {
        logger.info("收到自定义事件");
    }
}
