package com.javaVMwareDemo;

/**
 * @program: source-demo
 * @description:
 * @ClassName：Chapter01
 * @author: Mr.Wang
 * @create: 2022-02-27 09:56
 **/
public class Chapter01 {

    static boolean boolValue;
    public static void main(String[] args) {
        boolean boolValue = true; // 将这个 true 替换为 2 或者 3，再看看打印结果
        if (boolValue) {
            System.out.println("Hello, Java!");
        }
        if (boolValue == true) {
            System.out.println("Hello, JVM!");
        }
       
    }
}
