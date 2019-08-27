package com.daojia.study.proxy.stat;

/**
 * @author xiachao
 * @date 2019/5/14 17:14
 */
public class Hello implements IHello {
    @Override
    public void sayHello(String str) {
        System.out.println("Hello: say hello, str=" + str);
    }
}
