package com.daojia.study.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author xiachao
 * @since 2020/4/15 17:14
 */
public class Student {

    private String name;

    private Integer age;

    private Student1 student1;


    public Student1 getStudent1() {
        return student1;
    }

    public void setStudent1(Student1 student1) {
        this.student1 = student1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    class Student1 {

        private String hobby;

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }
    }

    public static void main(String[] args) {


        boolean aa = Objects.equals(null, "11");
        System.out.println(aa);

        String[] str = {"a", "b", "c"};
        for(String s : str){
            System.out.println(s);
        }
        System.out.println("```````````````````````");
        String[] strings1 = Arrays.copyOf(str, 6);
        for(String s : strings1){
            System.out.println(s);
        }
        strings1[5] = "2";
        System.out.println("```````````````````````");
        for(String s : strings1){
            System.out.println(s);
        }
        List<String> strings = Arrays.asList(str);
        //strings.add("c");
        System.out.println(strings);


        List<String> stringList = Arrays.stream(str).collect(Collectors.toList());

        for (String a : stringList) {
            if ("b".equals(a)) {
                stringList.remove(a);
            }

        }
        System.out.println(stringList);
        Integer[] a = {1,2,3};
        min(a);

    }

    //注意：Number并没有实现Comparable
    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) min = values[i];
        }
        return min;
    }


}
