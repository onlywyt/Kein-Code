package com.example.logbackdemo.com.test.source.arraylistsource.jmh;



import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ArrayListVSLinkedLIst
 * @author: Mr.Wang
 * @create: 2022-02-05 22:23
 **/
public class ArrayListVSLinkedLIst {

    private final static String Data = "DUMMY DATA";
    private final static int Max_CAPACITY= 1_000_000;
    private final static int  MAX_ITERATIONS = 10;

    private static void test(List<String> list){
        for (int i = 0; i < Max_CAPACITY; i++) {
            list.add(Data);
        }
    }

    private static void arraylistPerfTest(int iterations){
        for (int i = 0; i < iterations; i++) {
            final List<String> list = new ArrayList<>();
            final Stopwatch sw = Stopwatch.createStarted() ;
            test(list);
            System.out.println(sw.stop().elapsed(TimeUnit.MILLISECONDS));
        }
    }

    private static void linkedListPreTest(int iterations){
        for (int i = 0; i < iterations; i++) {
            final List<String> list = new ArrayList<>();
            final Stopwatch sw = Stopwatch.createStarted();
            test(list);
            System.out.println(sw.stop().elapsed(TimeUnit.MILLISECONDS));
        }
    }

    public static void main(String[] args) {
        arraylistPerfTest(MAX_ITERATIONS);
        System.out.println(Strings.repeat("#",100));
        linkedListPreTest(Max_CAPACITY);

    }
}
