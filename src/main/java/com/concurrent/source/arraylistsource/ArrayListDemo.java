package com.concurrent.source.arraylistsource;

import java.util.*;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ArrayListDemo
 * @author: Mr.Wang
 * @create: 2022-01-17 15:58
 **/
public class ArrayListDemo {

    ArrayList s = new ArrayList<Object>();

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<String>();
        queue. offer("string1"); // add
        System. out. println(queue. remove());//string1
        System. out. println(queue. poll());//null
        System. out. println(queue. size());//0


        System.out.println("-------");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        Iterator<String> it = list. iterator();
        while(it. hasNext()){
            String obj = it. next();
            System. out. println(obj);
        }
        System.out.println("-------");

        List<String> list3 = new ArrayList<>();
        list3. add("x");
        Collection<String> clist = Collections. unmodifiableCollection(list3);
        clist. add("y"); // 运行时此行报错java.lang.UnsupportedOperationException
        System. out. println(list3. size());
        System.out.println("-------");

        System.out.println(Math.round(-1.5));
        Long[] array1 = {1L, 2L};
        List<Long> list1 = Arrays.asList(array1);
        Object[] array2 = list1.toArray();
        System.out.println(array2.getClass() == Object[].class); // false
        List<Long> list2 = new ArrayList<>();
        System.out.println(list2.toArray().getClass() == Object[].class); // true

    }
}
