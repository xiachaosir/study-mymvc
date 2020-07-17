package com.daojia.study.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReenantTest {

    public static void main(String[] args) {

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();;
    }
}
