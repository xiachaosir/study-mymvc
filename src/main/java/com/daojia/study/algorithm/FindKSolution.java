package com.daojia.study.algorithm;

/*
   两个正序排序的数组，求合并后的第K个。两个数组内元素没有 0，找不到第 K 个数可以返回 0。

   示例 1：
   如果 K = 5
   >array1 = [1, 13, 16, 20]
   >array2 = [2, 8, 12, 27]
   >则第K个数是：13
   ====================================注意=========================================
   ====================================注意=========================================
   要求：
   1、不要申请额外的空间，比如：数组、List、Set、Map；
   2、不要使用java的sort相关函数，当然也不要自己手写冒泡排序或者其他排序，本题不是考察排序算法；
   3、需要写单元测试，写在 Code1_Test 内;
   4、穷举想到的测试边界case，而不仅仅是题目中示例的case；
*/
public class FindKSolution {

    public static int findK(int[] array1, int[] array2, int k) {
        int result = array1[0];
        int count = 0;
        int maxLenth = (array1.length - 1) * (array2.length - 1);
        for (int i = 1; i < maxLenth; i++) {

            if (result > array1[i]) {
                result = array1[i];
            }
            result = findB(result, array2, array1[i + 1]);
            count++;
            if (count == k - 1) {
                break;
            }
        }
        return result;
    }

    public static int findB(int tmp, int[] a, int a1) {
        for (int j = 0; j < a.length; j++) {
            if (a[j] > tmp && a[j] < a1) {
                tmp = a[j];
                break;
            }
        }
        return tmp;
    }

    public static int findK2(int[] array1, int[] array2, int k) {
        int i = 0;
        int j = 0;
        int tmp = 0;
        int count = 0;
        int maxLenth = array1.length + array2.length;
        while (i < array1.length || j < array2.length) {
            if (count == maxLenth -1) return 0;
            if (array1[i] < array2[j]) {
                tmp = array1[i];
                i++;
                count++;
            } else {
                tmp = array2[j];
                j++;
                count++;
            }
            if (count == k) break;
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 23, 24, 26};
        int[] a2 = {2, 8, 12, 27};
        System.out.println(findK2(a1, a2, 16));
    }
}

