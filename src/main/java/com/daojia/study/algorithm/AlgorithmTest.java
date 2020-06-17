package com.daojia.study.algorithm;

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

    public static void main(String[] args) {
        System.out.println("迭代-斐波那契数列第n个值为" + fibonacciDiedai(39));
        System.out.println("递归-斐波那契数列第n个值为" + fibonacciDigui(39));
    }


}
