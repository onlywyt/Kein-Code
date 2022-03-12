package com.concurrent.source.Java8Demo.PredicateDemo;

import cn.hutool.core.lang.copier.Copier;
import com.google.common.base.Supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @program: source-demoPriorityQueue
 * @description:
 * @ClassName：TestDemo
 * @author: Mr.Wang
 * @create: 2022-03-09 17:57
 **/
public class TestDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student[]{
                new Student("zs",89d),
                new Student("lisi",89d),
                new Student("wangwu",96d)
        });
        List<Student> studentSource = filter(students, t -> t.getSource() > 90);
        System.out.println(studentSource);
        System.out.println(filter(students, t -> t.getName().equals("zs")));

        System.out.println(mapToList(students, t -> t.getName().toUpperCase()));
        System.out.println(mapToList(students, t -> new Student(t.getName().toUpperCase(), t.getSource())));

        foreach(students,t -> t.setName(t.getName().toUpperCase()));

        Supplier<String> name = Student::getCollegeName;
        System.out.println(name.get().toString());
        Supplier<String> name1= () -> Student.getCollegeName();
        System.out.println(name1);
    }

    /**
     * PredicateDemo
     *
     * 列表过滤
     * @param list
     * @param predicate
     * @param <E>
     * @return
     */
    public static <E> List<E> filter(List<E> list, Predicate<E> predicate){
        List<E> retList = new ArrayList<>();
        for (E e : list) {
            if (predicate.test(e)){
                retList.add(e);
            }
        }
        return retList;
    }

    /**
     * FunctionDemo
     *
     * 转换。比如，给定一个学生列表，需要返回名称列表，或者将名称转换为大写返回
     * @param list
     * @param mapper
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> List<R> mapToList(List<T> list, Function<T,R> mapper){
        List<R> retList = new ArrayList<>(list.size());
        for (T e : list) {
            retList.add(mapper.apply(e));
        }
        return retList;
    }

    /**
     * ConsumerDemo
     *
     * 直接修改原对象
     * @param list
     * @param consumer
     * @param <E>
     */
    public static <E> void foreach(List<E> list, Consumer<E> consumer){
        for (E e : list) {
            consumer.accept(e);
        }
    }

}
