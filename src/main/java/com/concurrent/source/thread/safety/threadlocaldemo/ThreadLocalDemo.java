package com.concurrent.source.thread.safety.threadlocaldemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ThreadLocalDemo
 * @author: Mr.Wang
 * @create: 2022-01-20 11:03
 *  ThreadLocal 解决导致内存泄漏的方法：主动调用ThreadLocal中的remove方法。将ThreadLocal对象的值删除
 **/
public class ThreadLocalDemo {
    private static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
    private static ThreadLocal<DateFormat> dateFormatThreadLocal=new ThreadLocal<>();
    private static DateFormat getDateFormat(){
        DateFormat dateFormat = dateFormatThreadLocal.get();
        //每个线程通过parse()方法做格式转化时，都可以获得一个完全独立的SimpleDateFormat实例，
        // 由于这些线程不存在对于同一个共享实例的竞争，也就不存在线程安全问题了。
        if (dateFormat==null){
            dateFormat=new SimpleDateFormat(DATEFORMAT);
            dateFormatThreadLocal.set(dateFormat);
            dateFormatThreadLocal.remove();
        }
        return dateFormat;
    }
    public static Date parse(String date)throws ParseException {
        return getDateFormat().parse(date);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 9; i++) {
            executorService.execute(() ->{
                try {
                    System.out.println(parse("2022-09-09 16:32:10"));
                } catch (Exception exception){
                    exception.printStackTrace();
                }
            });
        }
    }
}
