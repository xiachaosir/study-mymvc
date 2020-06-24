package com.daojia.study.algorithm;

/**
 * @author xiachao
 * @since 2020/4/7 14:39
 */
public class LargeNumber {


    /**
     * "123"+"456"
     *
     * @param m
     * @param n
     * @return
     */
    public static String add(String m, String n) {
        char[] mChar = new StringBuffer(m).reverse().toString().toCharArray();
        char[] nChar = new StringBuffer(n).reverse().toString().toCharArray();
        int mLength = mChar.length;
        int nLength = nChar.length;
        int resultLength = mLength > nLength ? mLength + 1 : nLength + 1;
        int[] resultInt = new int[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int mint = i < mLength ? mChar[i] - '0' : 0;
            int nint = i < nLength ? nChar[i] - '0' : 0;
            resultInt[i] = mint + nint;
        }

        //做加法  大于10  往后进位 当前位对10求余
        for (int a = 0; a < resultLength; a++) {
            if (resultInt[a] >= 10) {
                resultInt[a + 1] += 1;
                resultInt[a] %= 10;
            }
        }
        StringBuffer result = new StringBuffer();
        int start = resultLength - 1;
        if (resultInt[resultLength - 1] == 0) {
            start = resultLength - 2;
        }
        for (int j = start; j >= 0; j--) {
            result.append(resultInt[j]);
        }
        return result.toString();

    }

    public static String sub(String m, String n) {

        return "";
    }


    public static String mul(String f, String s) {
        System.out.print("乘法：\n" + f + "*" + s + "=");
        // 获取首字符，判断是否是符号位
        char signA = f.charAt(0);
        char signB = s.charAt(0);
        char sign = '+';
        if (signA == '+' || signA == '-') {
            sign = signA;
            f = f.substring(1);
        }
        if (signB == '+' || signB == '-') {
            if (sign == signB) {
                sign = '+';
            } else {
                sign = '-';
            }
            s = s.substring(1);
        }
        // 将大数翻转并转换成字符数组
        char[] a = new StringBuilder(f).reverse().toString().toCharArray();
        char[] b = new StringBuilder(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        // 计算最终的最大长度
        int len = lenA + lenB;
        int[] result = new int[len];
        // 计算结果集合
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += (int) (a[i] - '0') * (int) (b[j] - '0');
            }
        }
        // 处理结果集合，如果是大于10的就向前一位进位，本身进行除10取余
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        // 该字段用于标识是否有前置0，如果是0就不需要打印或者存储下来
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        if (!sb.toString().equals("")) {
            if (sign == '-') {
                sb.insert(0, sign);
            }
        } else {
            sb.append(0);
        }
        // 返回最终结果
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(LargeNumber.mul("91", "792"));
    }
}
