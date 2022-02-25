package com.example.logbackdemo.com.designmuster.observer.listeners;

import java.io.File;

/**
 * @program: source-demo
 * @description: 通用观察者接口
 * @ClassName：EventListener
 * @author: Mr.Wang
 * @create: 2022-02-24 18:32
 **/
public interface EventListener {
    void update(String eventType, File file);
}
