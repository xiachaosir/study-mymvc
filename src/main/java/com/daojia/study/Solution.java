package com.daojia.study;

/**
 * 两个字符串
 * 加法
 * 789 +11 = 800
 * <p>
 * 9 8 7
 * 1 1
 * 10 9 7
 * 0 0 8
 */
public class Solution {

    public String twoStrAdd(String m, String n) {
        char[] charm = new StringBuffer(m).reverse().toString().toCharArray();
        char[] charn = new StringBuffer(n).reverse().toString().toCharArray();
        int maxLength = Math.max(charm.length, charn.length);
        int[] result = new int[maxLength + 1];
        for (int i = 0; i < maxLength; i++) {
            int mValue = i < charm.length ? charm[i] - '0' : 0;
            int nValue = i < charn.length ? charn[i] - '0' : 0;
            result[i] = mValue + nValue;
        }

        for (int j = 0; j < maxLength; j++) {
            if (result[j] >= 10) {
                result[j + 1] += result[j] / 10;
                result[j] = result[j] % 10;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int k = result.length - 1; k > 0; k--) {
            stringBuffer.append(result[k]);
        }

        return stringBuffer.toString();

    }


    public static void main(String[] args) {

    }


}
