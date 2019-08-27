package com.daojia.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * Created by chao.xia on 2017/9/22 11:10
 */
public class DynamicProxy implements InvocationHandler {


    Object targetObject;

    public Object getTargetObject(Object object) {
        this.targetObject = object;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Thread.sleep(1000);
        Object object = method.invoke(this.targetObject,args);
        return object;
    }


}

