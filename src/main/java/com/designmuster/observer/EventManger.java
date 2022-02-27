package com.designmuster.observer;

import com.designmuster.observer.listeners.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: source-demo
 * @description: publisher  基础发布者
 * @ClassName：EventManger
 * @author: Mr.Wang
 * @create: 2022-02-24 18:30
 **/
public class EventManger {

    Map<String, List<EventListener>> listeners = new HashMap();

    public EventManger(String... operations){
        for (String operation : operations) {
            this.listeners.put(operation,new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType,EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }


    public void notify(String eventType, File file){
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType,file);
        }
    }

}
