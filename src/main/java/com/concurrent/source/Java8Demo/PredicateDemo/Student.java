package com.concurrent.source.Java8Demo.PredicateDemo;

import lombok.Data;

/**
 * @program: source-demo
 * @description:
 * @ClassName：Student
 * @author: Mr.Wang
 * @create: 2022-03-09 17:57
 **/
@Data
public class Student {

    public static String getCollegeName(){
        return "Laoma School";
    }


    private String name;
    private double source;

    public Student(String name, double source) {
        this.name = name;
        this.source = source;
    }
}
