package com.concurrent.source.Java8Demo;

import java.io.File;
import java.util.Arrays;

/**
 * @program: source-demo
 * @description:
 * @ClassName：LanbdaDemo
 * @author: Mr.Wang
 * @create: 2022-03-09 17:48
 **/
public class LanbdaDemo {

    public static void main(String[] args) {
        demo1();


    }



    private static void demo1() {
        //知道listFiles接受的参数类型是FilenameFilter，这个接口只有一个方法accept，这个方法的两个参数类型分别是File和String
        File file = new File(".");
        file.listFiles((File dir,String name)-> name.endsWith(".txt"));
    }
}
