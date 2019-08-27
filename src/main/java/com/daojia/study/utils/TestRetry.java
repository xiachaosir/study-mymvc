package com.daojia.study.utils;

/**
 * @author xiachao
 * @date 2019/8/13 14:39
 */
public class TestRetry {

    public static void main(String[] args) {

        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                count++;
                if (count == 2) {
                    continue;
                }
                System.out.println("i=" + i + ",j=" + j + ",count=" + count);
            }
        }

        System.out.println("---------------------------------");
        int sum = 0;
        retry:
        for (int m = 0; m < 10; m++) {
            sum++;
            if (sum == 2) {
                break retry;
            }
            System.out.println("m=" + m + ",sum=" + sum);
        }

        for (;;) {
            System.out.println("hhaha");
        }


    }
}
