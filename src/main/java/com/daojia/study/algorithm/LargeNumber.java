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
        int sum = 0;
        int[] resultInt = new int[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int mint = i < mLength ? mChar[i] - '0' : 0;
            int nint = i < nLength ? nChar[i] - '0' : 0;
            sum += mint + nint;
            resultInt[i] = sum;
            if (sum >= 10) {
                resultInt[i] %= 10;
            }
            sum = sum / 10;
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
        new StringBuffer(m).reverse().toString().toCharArray();

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
        System.out.println(LargeNumber.add("18", "198"));
        //System.out.println(ip2Int("127.0.0.1"));
        //System.out.println(intToIp(16777343));
        //System.out.println(ipToLong("127.0.0.1"));
        //System.out.println(longToIP(2130706433));
    }

    /**
     * 将 ip 字符串转换为 int 类型的数字
     * <p>
     * 思路就是将 ip 的每一段数字转为 8 位二进制数，并将它们放在结果的适当位置上
     *
     * @param ipString ip字符串，如 255.255.255.255
     *                 00000000 00000000 00000000 00000000
     *                 00000000 00000000 00000000 11111111
     *                 ------------或运算------------
     *                 00000000 00000000 00000000 11111111
     *                 00000000 00000000 11111111 00000000
     *                 ------------或运算------------
     *                 00000000 00000000 11111111 11111111
     *                 00000000 11111111 00000000 00000000
     *                 ------------或运算------------
     *                 00000000 11111111 11111111 11111111
     *                 11111111 00000000 00000000 00000000
     *                 -----------最终结果------------
     *                 11111111 11111111 11111111 11111111
     * @return ip字符串对应的 int 值
     */
    public static int ip2Int(String ipString) {
        // 取 ip 的各段
        String[] ipSlices = ipString.split("\\.");
        int rs = 0;
        for (int i = 0; i < ipSlices.length; i++) {
            // 将 ip 的每一段解析为 int，并根据位置左移 8 位
            int intSlice = Integer.parseInt(ipSlices[i]) << (8 * i);
            // 求或
            rs = rs | intSlice;
        }
        return rs;
    }

    public static String intToIp(int ipInt) {
        StringBuffer sb = new StringBuffer("");
        sb.append((ipInt & 255));
        sb.append(".");
        sb.append((ipInt & 255) >>> 8);
        sb.append(".");
        sb.append((ipInt & 255) >>> 16);
        sb.append(".");
        //右移24位
        sb.append((ipInt >>> 24));
        return sb.toString();
    }

    public static String longToIP(long longIp) {
        StringBuffer sb = new StringBuffer("");
        // 直接右移24位
        sb.append((longIp >>> 24));
        sb.append(".");
        // 将高8位置0，然后右移16位
        sb.append((longIp & 0x00FFFFFF) >>> 16);
        sb.append(".");
        // 将高16位置0，然后右移8位
        sb.append((longIp & 0x0000FFFF) >>> 8);
        sb.append(".");
        // 将高24位置0
        sb.append((longIp & 0x000000FF));
        return sb.toString();
    }

    public static long ipToLong(String strIp) {
        long[] ip = new long[4];
        // 先找到IP地址字符串中.的位置
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        // 将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(strIp.substring(0, position1));
        ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(strIp.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

}
