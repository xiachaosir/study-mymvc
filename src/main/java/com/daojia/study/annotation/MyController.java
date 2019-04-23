package com.daojia.study.annotation;

import java.lang.annotation.*;

/**
 * Created by xiachao on 2018/8/1 20:11
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyController {

    String value() default "";
}
