package com.example.logbackdemo.com.designmuster.observer.listeners;

import java.io.File;

/**
 * @program: source-demo
 * @description: 收到通知后，在日志记录消息
 * @ClassName：LogOpenListener
 * @author: Mr.Wang
 * @create: 2022-02-24 18:51
 **/
public class LogOpenListener implements EventListener{

    private File logFile;

    public LogOpenListener(String logFile){
        this.logFile = new File(logFile);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log:" + logFile + ":Someome has performed" + eventType);
    }
}

