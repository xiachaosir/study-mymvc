package com.daojia.study.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiachao
 * @date 2019/6/13 15:04
 */
public class JvmTest {

    public static void main(String[] args) {
        JvmTest jvmTest = new JvmTest();
        System.out.println("22222222");
        /*List list = new ArrayList();
        while (true) {
            list.add(new JvmTest());
        }*/

        /*List<String> integers = new ArrayList<>();
        int i = 0;
        while (true) {
            integers.add(String.valueOf(i++).intern());
        }*/

        String str1 = new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);   //计算机软件 首次出现 intern只是在常量池中记录首次出现的实例引用

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);




    }
}
