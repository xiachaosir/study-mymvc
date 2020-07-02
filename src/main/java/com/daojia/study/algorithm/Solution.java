package com.daojia.study.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
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
     * 数据流中找第K大的 冒泡 每次冒一个最小的元素
     */
    public static int findK(int[] arr, int k) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[i]) {
                    int tmp = arr[j];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            if (s++ >= k) break;
        }
        return arr[arr.length - k];
    }

    /**
     * 用PriorityQueue实现选择最小的k个数
     *
     * @param array 数组
     * @param k
     * @return
     */
    public int[] selectKmin(int[] array, int k) {
        int[] res = new int[k];
        //创建一个降序排列的PriorityQueue，自定义比较器作为参数
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(array[i]);
            } else {
                int maxInQueue = priorityQueue.peek();
                if (maxInQueue > array[i]) {//每次取数与堆顶的元素进行比较，
                    //如果堆顶元素大，则删除堆顶元素，并添加这个新数到堆中
                    priorityQueue.poll();
                    priorityQueue.add(array[i]);
                }
            }
        }
        //升序存放
        for (int i = 0; i < k; i++) {
            res[k - i - 1] = priorityQueue.poll();
        }
        return res;
    }
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
    /**
     * 使用优先级队列
     */
    public static int findKQueue(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        /*String[] str = {"flower", "flow", "floweght"};
        System.out.println(commonPrefix(str));*/
        String[] arr = { "{", "}"};
        System.out.println(dealKuohao(arr));

        int[] arr1 = {3, 1, 4, 2, 6};
        System.out.println(findK(arr1, 5));

        System.out.println(findKQueue(arr1, 5));

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;

    }


}
