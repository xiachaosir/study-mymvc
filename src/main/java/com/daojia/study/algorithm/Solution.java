package com.daojia.study.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xiachao
 * @since 2020/6/8 18:54
 */
public class Solution {

    //最长公共前缀

    private static String commonPrefix(String[] str) {

        Arrays.sort(str);
        int length = str[0].length();
        String s = str[str.length - 1];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (str[0].charAt(i) == s.charAt(i)) {
                stringBuilder.append(str[0].charAt(i));
            }
        }
        return stringBuilder.toString();

    }

    /**
     * 数据流中找第K大的
     */







    public static void main(String[] args) {
        String[] str = {"flower", "flow", "floweght"};
        System.out.println(commonPrefix(str));

    }


}
