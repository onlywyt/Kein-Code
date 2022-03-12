package com.concurrent.source.Java8Demo.PredicateDemo;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Collectors.*;

import static java.util.stream.Collectors.*;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ToMapDemo
 * @author: Mr.Wang
 * @create: 2022-03-12 21:08
 **/
public class ToMapDemo {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student[]{
                new Student("zs",89d),
                new Student("lisi",89d),
                new Student("wangwu",96d)
        });

        List<Student1> students1 = Arrays.asList(new Student1[]{
                new Student1("zs","1",89d),
                new Student1("lisi","2",89d),
                new Student1("wangwu","1",96d)
        });

        //获取每个年级分数最高的一个学生;返回一个Option
        Map<String, Optional<Student1>> collect = students1.stream()
                .collect(groupingBy(Student1::getGrade, maxBy(Comparator.comparing(Student1::getSource))));
        //获取每个年级分数最高的一个学生;返回一个Student
        Map<String, Student1> collect1 = students1.stream().collect(groupingBy(Student1::getGrade, collectingAndThen(maxBy(
                Comparator.comparing(Student1::getSource)), Optional::get)));

        //System.out.println(collect);

        //按年级统计学生分数信息;分数和，平均分，最低分，最高分
        Map<String, DoubleSummaryStatistics> collect2 = students1
                .stream()
                .collect(groupingBy(Student1::getGrade, summarizingDouble(Student1::getSource)));
        System.out.println(collect2);


        groupByDemo(students1);


        toMapDemo(students);

        joiningDemo();


    }

    /**
     * 分组
     * @param students1
     */
    private static void groupByDemo(List<Student1> students1) {
        Map<String, List<Student1>> collect = students1.stream().collect(groupingBy(s -> s.getGrade()));
        System.out.println(collect);
    }

    private static void joiningDemo() {
        String collect = Stream.of("abc", "老王", "hello").collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }


    private static void toMapDemo(List<Student> students) {
        Map<String, Double> stringDoubleMap = students.stream().collect(Collectors.toMap(Student::getName, Student::getSource));
        System.out.println(stringDoubleMap);
        stringDoubleMap.entrySet().stream().forEach(e -> System.out.println(e.getValue()));


        //将一个对象列表按主键转换为一个Map
        Map<String, Student> collect = students.stream().collect(Collectors.toMap(Student::getName, t -> t));
    }
}
