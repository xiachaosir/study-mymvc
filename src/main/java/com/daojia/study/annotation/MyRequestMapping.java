package com.daojia.study.annotation;

import java.lang.annotation.*;

/**
 * Created by xiachao on 2018/8/2 10:41
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {


    String value();
}
