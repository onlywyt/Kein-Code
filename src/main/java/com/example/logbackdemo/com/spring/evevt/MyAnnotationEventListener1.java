package com.example.logbackdemo.com.spring.evevt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: logbackdemo
 * @description: 监听多个事件，包括自定义事件
 * @ClassName：MyAnnotationEventListener1
 * @author: Mr.Wang
 * @create: 2022-01-16 17:19
 **/
@Component
public class MyAnnotationEventListener1 {
    private static final Logger logger = LoggerFactory.getLogger(MyAnnotationEventListener1.class);

    //被@EventListener注解标注的方法入参为MyEvent类型，所以只要MyEvent事件被发布了，该监听器就会起作用，即该方法会被回调。
    @EventListener(classes = {MyEvent.class, ContextRefreshedEvent.class, ContextClosedEvent.class})
    public void onMyEventPublished(ApplicationEvent myEvent){
        if (myEvent instanceof MyEvent){
            logger.info("监听自定义事件MyEvent");
        } else if (myEvent instanceof ContextRefreshedEvent){
            logger.info("监听自定义事件ContextRefreshedEvent");
        }else if (myEvent instanceof ContextClosedEvent){
            logger.info("监听自定义事件ContextClosedEvent");
        }
    }
}
