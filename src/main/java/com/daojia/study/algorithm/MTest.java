package com.daojia.study.algorithm;

import com.daojia.study.algorithm.listnode.ListNode;

import java.math.BigDecimal;

public class MTest {

    /**
     * 求链表的相交点
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 合并有序链表
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return pre.next;
    }


    /**
     * 链表反转
     */
    public static ListNode reverseNode(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode next = cur.next; //保存下一个节点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    /**
     * K个一组反转链表
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode pre = temp;
        ListNode end = temp;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseNode(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return temp.next;
    }

    /**
     * 求一个数的平方根
     * 方法2，易于理解，精确度高
     */
    public static Double squareRoot(int a) {
        double x = 0;
        double low = 0;
        double high = a;
        while (low <= high) {
            x = (low + high) / 2;
            if (x > a / x) {
                high = x - 0.000001;
            }
            //防止溢出
            if (x < a / x) {
                low = x + 0.000001;
            }
            if (x == a / x) {
                //刚好整除
                return x + 0.000001;
            }
        }
        //精确到六位小数
        return new BigDecimal(x).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 立方根
     */
    public static Double cubic(int a) {
        double x = 0;
        double low = 0;
        double high = a;
        while (low <= high) {
            x = (low + high) / 2;
            if (x > a / x / x) {
                high = x - 0.000001;
            }
            //防止溢出
            if (x < a / x / x) {
                low = x + 0.000001;
            }
            if (x == a / x / x) {
                //刚好整除
                return x + 0.000001;
            }
        }
        //精确到六位小数
        return new BigDecimal(x).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 计算公式
     * pai = 2 * (1/1 + 1/3 + 1/3 * 2/5 + 1/3 * 2/5 * 3/7 + ....)
     */
    static double jishuPI(double z) {
        double sum = 2;
        int n = 1;
        int m = 3;
        double t = 2;
        while (t > z) {
            t = t * n / m;
            sum = sum + t;
            n++;
            m += 2;
        }
        return sum;
    }

    public static void main(String[] args) {

        double z = 0.000000001;
        System.out.println(jishuPI(z));


        ListNode listNode6 = new ListNode(8);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(7, listNode5);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(6, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println("原链表: " + listNode1);

        //System.out.println("反转后的链表: " + reverseNode(listNode1));

        int k = 3;
        System.out.println(k + "个一组反转链表后：" + reverseKGroup(listNode1, k));


        System.out.println(squareRoot(3));
        System.out.println(cubic(3));

    }
}
