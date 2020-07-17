package com.daojia.study.algorithm;

import java.util.ArrayList;

/**
 * @author xiachao
 * @since 2020/6/11 11:08
 */
public class FullPermutation {

    public static void main(String[] args) {
        String s[] = {"1", "2", "3"};
        int a[] = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        long startTime = System.currentTimeMillis();
        arrange(a, 0, a.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime) + "ms");
    }

    static void arrange(int a[], int start, int end) {
        //停止
        if (start == end) {
            for (int i : a) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        //不停止
        for (int i = start; i <= end; i++) {
            ///i是从该层后面所有可能的全部要选一次排列到该层
            swap(a, i, start);
            ///该层确定，进入下一层子递归
            arrange(a, start + 1, end);
            //因为不能影响同层之间数据，要保证数据都是初始化
            swap(a, i, start);
        }
    }

    static void swap(int arr[], int i, int j) {
        int te = arr[i];
        arr[i] = arr[j];
        arr[j] = te;
    }

}
