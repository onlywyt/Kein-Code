package com.concurrent.source.thread.safety.deadlock.brokedeaadlock;

/**
 * @program: source-demo
 * @description: 资源类。用来测试死锁;
 * 解决死锁办法：按照顺序给资源加锁。hashcode()方法；根据hashCode的大小确定加锁的对象
 * @ClassName：Resource
 * @author: Mr.Wang
 * @create: 2022-01-19 17:03
 **/
public class Resource1 {

    private String name;
    private int count;

    public Resource1(String name) {
        this.name = name;
    }

    public void statisticsResource(){
        synchronized (this){
            System.out.println("statistics resource");
            count++;
            System.out.println(count);
        }
    }
    public void saveResource(Resource1 resource){
        Resource1 lock = this.hashCode()> resource.hashCode()?this:resource;
            synchronized (lock){
            System.out.println("save resource");
            resource.statisticsResource();
            }
    }

}
