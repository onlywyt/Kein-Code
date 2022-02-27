package com.concurrent.source.base;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: source-demo
 * @description:
 * @ClassName：StringDemo
 * @author: Mr.Wang
 * @create: 2022-01-29 17:24
 **/
public class StringDemo {

    public static void main(String[] args) {
        String string1 = "abc";
        String string2 = "def";
        int compare = StringDemo.compare(string1, string2);
        System.out.println(compare);

        /**
         *sort方法默认是从小到大排序，如果希望按照从大到小排序呢？对于对象类型，
         * 可以指定一个不同的Comparator，可以用匿名内部类来实现Comparator
         */
        String[] arr = {"hello","world", "Break","abc"};
        Arrays.sort(arr,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    //忽略大小写的方法
    public static int compare(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);
                if (c1 != c2) {
                    c1 = Character.toLowerCase(c1);
                    c2 = Character.toLowerCase(c2);
                    if (c1 != c2) {
                        // No overflow because of numeric promotion
                        return c1 - c2;
                    }
                }
            }
        }
        return n1 - n2;
    }
}
