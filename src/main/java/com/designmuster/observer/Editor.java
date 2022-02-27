package com.designmuster.observer;

import java.io.File;

/**
 * @program: source-demo
 * @description: editor  具体发布者，由其他对象追踪
 * @ClassName：Editor
 * @author: Mr.Wang
 * @create: 2022-02-24 18:39
 **/
public class Editor {

    public EventManger events;
    private File file;

    public Editor(){
        this.events = new EventManger("open", "save");
    }
    public void openFile(String filePath){
        this.file = new File(filePath);
        events.notify("open",file);
    }

    public void saveFile() throws Exception{
        if (this.file != null) {
            events.notify("save",file);
        } else {
            throw new Exception("Plese open a file frist.");
        }
    }

}
