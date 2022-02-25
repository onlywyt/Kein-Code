package com.example.logbackdemo.com.designmuster.observer.listeners;

import java.io.File;

/**
 * @program: source-demo
 * @description: 收到通知后发送邮件
 * @ClassName：EmailNotificationListener
 * @author: Mr.Wang
 * @create: 2022-02-24 18:49
 **/
public class EmailNotificationListener implements EventListener {

    private String email;

    public EmailNotificationListener(String email){
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Emile to :" + email + ": Someone has preformed: " + eventType);
    }

}
