package com.daojia.study;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(6);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (Integer i : list) {
            System.out.print(i + "  ");
        }
    }


}
