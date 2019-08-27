package com.daojia.study.thread;

/**
 * ABCABCABC…… 依次递归
 *
 * @author xiachao
 * @date 2019/7/30 16:25
 */
public class ThreadConditionDemo {


    public static void main(String[] args) {
        Worker worker = new Worker();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    worker.loopA();
                }

            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    worker.loopB();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    worker.loopC();
                }
            }
        }, "C").start();


    }


}
