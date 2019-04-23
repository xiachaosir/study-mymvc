package com.daojia.study.practice;

import com.daojia.study.domain.User;

/**
 * Created by xiachao on 2018/8/22 14:23
 */
public class TestFinal {

    public static void modifyUser1(final User user) {

        user.setName("xiachao");

    }


    public static void modifyUser2(final User user) {

        user.setAge(20);

    }

    public static void main(String[] args) {
        User user = new User();
        modifyUser1(user);
        System.out.println("user="+ user.toString());
        modifyUser2(user);
        System.out.println("user=" + user.toString());

        String name = "abc";

        modifyName(name);
        System.out.println(name);


    }

    private static void modifyName(String name) {
        name = "123232";
    }


}


