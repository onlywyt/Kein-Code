package com.concurrent.source.genericity;

import java.util.Random;

/**
 * @program: source-demo
 * @description:
 * @ClassName：TestDynameincarray
 * @author: Mr.Wang
 * @create: 2022-02-20 11:49
 **/
public class TestDynameincarray {

    public static void main(String[] args) {
        demo2();

        demo1();
    }

    private static void demo2() {
        DynamicArray<Double> array = new DynamicArray();
        Random random = new Random();
        int size = 1 + random.nextInt(100);
        for (int i = 0; i < size; i++) {
            array.add(Math.random());
        }
        Double d = array.get(random.nextInt(size));
        System.out.println(d);
    }

    private static void demo1() {
        DynamicArray<Number> numbers  = new DynamicArray();
        DynamicArray<Integer> ints  = new DynamicArray();
        ints.add(100);
        ints.add(34);
        numbers.addAll(ints);
        System.out.println(numbers.get(1));
    }
}
