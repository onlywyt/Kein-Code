package com.example.logbackdemo.com.test.source.genericity;

import java.util.Arrays;

/**
 * @program: source-demo
 * @description: 泛型demo
 * @ClassName：DynamicArray
 * @author: Mr.Wang
 * @create: 2022-02-20 11:44
 **/
public class DynamicArray<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementsData;
    public DynamicArray(){
        this.elementsData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity){
        int oldCapacity = elementsData.length;
        if (oldCapacity >= minCapacity){
            return;
        }
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementsData = Arrays.copyOf(elementsData, newCapacity);
    }

    public void add(E e){
        ensureCapacity(size + 1);
        elementsData[size++] = e;
    }
    public E get(int index){
        return (E)elementsData[index];
    }

    public E set(int index, E element){
        E oldE = get(index);
        elementsData[index] = element;
        return oldE;
    }

    /**
     * c的类型是DynamicArray<？extends E>，？表示通配符，<？extends E>表示有限定通配符，
     * 匹配E或E的某个子类型，具体什么子类型是未知的
     * @param c
     */
    public void addAll(DynamicArray<? extends E> c){
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }

    }
}
