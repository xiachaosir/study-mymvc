package com.daojia.study.proxy.stat;

/**
 * @author xiachao
 * @date 2019/5/14 17:17
 */
public class Test {
    public static void main(String[] args) {
        IHello hello = new HelloProxy(new Hello());
        hello.sayHello("haha");
    }
}
