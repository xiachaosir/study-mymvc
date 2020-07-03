package com.daojia.study.algorithm;

public class SortTest {
    /**
     * 插入排序 以第一个为基准 作为有序数组 把后一个数字插入到有序列表中，其余位置往后移动
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
        for (int m = 0; m < arr.length; m++) {
            System.out.print(arr[m] + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 13, 2, 9, 1};
        insertSort(arr);
    }

}
