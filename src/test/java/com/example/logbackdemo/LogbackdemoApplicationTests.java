package com.example.logbackdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

@SpringBootTest
class LogbackdemoApplicationTests {

    @Test
    void contextLoads() {
        HashSet sets = new HashSet<Integer>();
        sets.add(1111);
        sets.add(22);
        sets.add(3);
        sets.add(4);
        for (Object s : sets) {
            System.out.println(s);
        }
    }

    @Test
    void contextLoads0() {
        HashSet<Integer> set = new HashSet<>();
        int [] nums = {1,23,3,3,4} ;
        for (int num : nums) {
            if(!set.add(num)){
                System.out.println(num);
            }
        }
    }

    @Test
    void contextLoads1() {
        TreeSet sets = new TreeSet();
        sets.add(1111);
        sets.add(22);
        sets.add(3);
        sets.add(4);
        for (Object s : sets) {
            System.out.println(s);
        }
    }
    @Test
    void contextLoads2() {
        int target = 5;
        HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
        int[] nums = {1,2,4};
        int[] a = new int[2];
        map.put(nums[0],0);
        for (int i = 0; i < nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                a[0] = map.get(target -nums[i]);
                a[1] = i;
                System.out.println(a[0]);
                System.out.println(a[1]);
            } else {
                map.put(nums[i], i);
            }
        }
    }

}
