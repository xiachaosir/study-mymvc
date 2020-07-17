package com.daojia.study.thread.poll;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;

public class ThreadPoolTest {


    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            10, 10,
            10, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(2000),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111-");
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("2222-");
                int a = 2 / 0;
                System.out.println(a);
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("3333-");
            }
        });

    }
}
