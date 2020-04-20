package com.daojia.study.utils;

import java.util.Arrays;

/**
 * 实现栈
 *
 * @author xiachao
 * @since 2020/4/16 16:31
 */
public class MyStack {

    //元素个数
    private int count;

    //容量
    private int capacity;

    //元素
    private int[] storage;

    private int GROW_FACTOR = 2;

    public MyStack() {
        this.capacity = 8;
        this.storage = new int[8];
        this.count = 0;
    }

    public MyStack(int initCapacity) {
        if (initCapacity <= 1) {
            throw new IllegalArgumentException("too small");
        }
        this.capacity = initCapacity;
        this.storage = new int[initCapacity];
        this.count = 0;
    }

    //入栈
    public void push(int value) {
        if (count == capacity) {
            increaseCapacity();
        }
        storage[count++] = value;
    }

    //出栈
    public int pop() {
        if (count == 0) {
            throw new IllegalArgumentException("栈中已经没有数据啦");
        }
        int i = storage[--count];
        storage = Arrays.copyOf(storage, count);
        return i;
    }

    //出栈
    public int popNotDelete() {
        if (count == 0) {
            throw new IllegalArgumentException("栈中已经没有数据啦");
        }
        return storage[count-1];
    }


    private void increaseCapacity() {
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(2);
        myStack.push(1);
        myStack.push(2);
        for (int i : myStack.storage) {
            System.out.println(i);
        }
        int pop = myStack.popNotDelete();
        System.out.println("栈顶元素为:" + pop);
        System.out.println("count=" + myStack.count);
        System.out.println("------------------");
        for (int i : myStack.storage) {
            System.out.println(i);
        }
    }


}
