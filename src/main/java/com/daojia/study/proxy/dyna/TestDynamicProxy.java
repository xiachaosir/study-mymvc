package com.daojia.study.proxy.dyna;


import com.daojia.study.proxy.stat.Hello;
import com.daojia.study.proxy.stat.IHello;

/**
 * @author xiachao
 * @date 2019/5/14 17:32
 */
public class TestDynamicProxy {

    public static void main(String[] args) {
        IHello hello = (IHello) new HelloDynaProxy().bind(new Hello());
        hello.sayHello("hahaa");
    }
}
