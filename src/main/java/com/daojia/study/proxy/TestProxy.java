package com.daojia.study.proxy;

/**
 * Created by chao.xia on 2017/9/22 14:28
 */
public class TestProxy {

    public static void main(String[] args) {

        A a = (A) new DynamicProxy().getTargetObject(new B());

        a.add(1,2);

    }
}
