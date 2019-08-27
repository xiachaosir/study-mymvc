package com.daojia.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiachao
 * @date 2019/7/30 16:51
 */
public class Worker {

    private volatile int number = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void loopA() {
        lock.lock();
        try {
            if (number != 1) {
                condition1.await();
            }
            System.out.print(Thread.currentThread().getName());
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            System.out.println("loopA error=" + e);
        } finally {
            lock.unlock();
        }
    }


    public void loopB() {
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }
            System.out.print(Thread.currentThread().getName());
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            System.out.println("loopA error=" + e);
        } finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();
        try {
            if (number != 3) {
                condition3.await();
            }
            System.out.print(Thread.currentThread().getName());
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            System.out.println("loopA error=" + e);
        } finally {
            lock.unlock();
        }
    }


}
