package com.daojia.study.proxy;

/**
 * Created by chao.xia on 2017/9/22 14:24
 */
public class B implements A {
    @Override
    public void add(int a, int b) {
        System.out.println("a+b的结果是"+(a+b));
    }
}
