package com.daojia.study.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

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


    /**
     * 数组里面包含 [] {} ，最后可以消掉完，返回true，] {} []这种返回false
     *
     * @param s
     */

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("]", "[");
        map.put("}", "{");
    }

    public static boolean dealKuohao(String[] str) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (map.containsKey(s)) {

                if (!s.equals(map.get(s))) {
                    return false;
                }

            } else {
                stack.push(s);
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        /*String[] str = {"flower", "flow", "floweght"};
        System.out.println(commonPrefix(str));*/
        String[] arr = { "{", "}"};
        System.out.println(dealKuohao(arr));

    }


}
