package com.designmuster.observer;

import com.designmuster.observer.listeners.EmailNotificationListener;
import com.designmuster.observer.listeners.LogOpenListener;

/**
 * @program: source-demo
 * @description: 测试代码
 * @ClassName：Demo
 * @author: Mr.Wang
 * @create: 2022-02-24 18:53
 **/
public class Demo {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open",new LogOpenListener("/Users/yingtaowang/Documents/个人/code/wyt/source-demo/src/main/resources/file.txt"));
        editor.events.subscribe("save",new EmailNotificationListener("809028433@qq.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
