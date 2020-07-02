package com.daojia.study.thread;

import com.daojia.study.domain.User;

public class ThreadLocalTest {

    private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    private static  ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User();
                user.setName("张三");
                threadLocal.set(user);
                threadLocal2.set(1);
                System.out.println(threadLocal.get().toString());
                System.out.println(threadLocal2.get().toString());
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                User user1 = new User();
                user1.setName("李四");
                threadLocal.set(user1);
                threadLocal2.set(2);
                System.out.println(threadLocal.get().toString());
                System.out.println(threadLocal2.get().toString());
            }
        }).start();
    }
}
