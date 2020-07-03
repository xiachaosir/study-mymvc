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

    }
}
