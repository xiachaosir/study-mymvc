package com.daojia.study.algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 算法
 *
 * @author xiachao
 * @date 2019/8/13 17:14
 */
public class AlgorithmTest {

    /**
     * 斐波那契数列 1、1、2、3、5、8、13、21、34  迭代法
     *
     * @param num
     * @return
     */
    public static int fibonacciDiedai(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        int first = 1, second = 1, third = 0;
        for (int i = 3; i <= num; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 斐波那契数列递归
     *
     * @param num
     * @return
     */
    public static int fibonacciDigui(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fibonacciDigui(num - 1) + fibonacciDigui(num - 2);
    }

    /**
     * 数据流中找第K大的
     */
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            //当queue的大小大于k，每次弹出堆顶的最小元素；
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }

    public static int getMaxK(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
            //if (s++ == k) break;
        }
        /*for (int i = 0 ; i < a.length ; i ++) {
            System.out.print(a[i] + " ");
        }*/
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        /*System.out.println("迭代-斐波那契数列第n个值为" + fibonacciDiedai(39));
        System.out.println("递归-斐波那契数列第n个值为" + fibonacciDigui(39));*/

        int[] a = {1, 4, 5, 6, 2, 6};
        System.out.println(getMaxK(a, 2));
    }


}
