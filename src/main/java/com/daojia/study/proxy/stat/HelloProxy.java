package com.daojia.study.proxy.stat;

/**
 * @author xiachao
 * @date 2019/5/14 17:15
 */
public class HelloProxy implements IHello {

    private IHello hello;

    public HelloProxy(IHello hello) {
        this.hello = hello;
    }

    @Override
    public void sayHello(String str) {
        System.out.println("HelloProxy: start");
        hello.sayHello(str);
        System.out.println("HelloProxy: end");
    }

}
