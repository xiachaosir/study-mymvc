package com.daojia.study.algorithm;

/**
 * @author xiachao
 * @since 2020/7/3 15:56
 */
public class Dp {


    public static int getMaxValue(int[] vlaue, int[] weight, int w) {
        //初始化动态规划数组int
        int[][] dp = new int[weight.length + 1][w + 1];
        //将dp[i][0]和dp[0][j]均置为0
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (weight[i - 1] <= j) {
                    //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                    //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                    //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                    dp[i][j] = Math.max(vlaue[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    //如果第i件物品的重量大于背包容量j,则不装入背包
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weight.length][w];
    }

    public static void main(String[] args) {
        //价值
        int[] vlaue = {6, 10, 12};
        //重量
        int[] weight = {1, 2, 4};
        //容量
        int w = 5;
        //System.out.println("最大价值=" + getMaxValue(vlaue, weight, w));
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
