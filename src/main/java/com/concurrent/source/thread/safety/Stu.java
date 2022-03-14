package com.concurrent.source.thread.safety;

/**
 * @program: source-demo
 * @description:
 * @ClassName：Stu
 * @author: Mr.Wang
 * @create: 2022-03-13 16:31
 **/
public class Stu {

    @Override
    public String toString() {
        return "Stu{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }

    private String id;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Stu(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public Stu(String id) {
        this.id = id;
    }
    public Stu() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
