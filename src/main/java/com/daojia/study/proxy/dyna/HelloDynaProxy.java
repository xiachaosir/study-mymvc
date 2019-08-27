package com.daojia.study.proxy.dyna;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiachao
 * @date 2019/5/14 17:30
 */
public class HelloDynaProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object object) {
        this.target = object;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }
}
