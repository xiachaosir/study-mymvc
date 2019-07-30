package com.daojia.study.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author xiachao
 * @date 2019/5/17 11:23
 */
public class A extends B{


    public A(String string) {
        super(string);
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(Integer.MAX_VALUE));

        Random random2 = new Random();


        Map<String,String> map = new HashMap<>();
        map.put("1","1");

        map.get("1");
    }
}
