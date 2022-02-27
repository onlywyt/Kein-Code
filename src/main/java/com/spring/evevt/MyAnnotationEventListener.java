package com.spring.evevt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: logbackdemo
 * @description: 自定义事件监听
 * @ClassName：MyAnnotationEventListener
 * @author: Mr.Wang
 * @create: 2022-01-16 16:39
 **/
@Component
public class MyAnnotationEventListener {
    private static final Logger logger = LoggerFactory.getLogger(MyAnnotationEventListener.class);

    //被@EventListener注解标注的方法入参为MyEvent类型，所以只要MyEvent事件被发布了，该监听器就会起作用，即该方法会被回调。
    @EventListener
    public void onMyEventPublished(MyEvent myEvent){
        logger.info("收到自定义事件MyEvent -- MyAnnotationEventListener");
    }

}
