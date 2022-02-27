package com.spring.evevt;

import org.springframework.context.ApplicationEvent;

/**
 * @program: logbackdemo
 * @description: 自定义事件业务类
 * @ClassName：MyEvent
 * @author: Mr.Wang
 * @create: 2022-01-16 16:34
 **/
public class MyEvent extends ApplicationEvent {
    //构造器source参数表示当前事件的事件源，一般传入Spring的context上下文对象即可。
    public MyEvent(Object source) {
        super(source);
    }
}
