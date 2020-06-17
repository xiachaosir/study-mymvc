package com.daojia.study.algorithm.listnode;

/**
 * @author xiachao
 * @since 2020/4/20 16:46
 */
public class ListNodeTest {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || 0 == k || 1 == k) return head;

        int n = 0;
        ListNode cur = head;

        while (cur != null) {
            n++;
            cur = cur.next;
        }

        cur = head;

        int cnt = n / k, remainder = n % k;

        ListNode ans = null;
        ListNode tail = null;
        for (int i = 0; i < cnt; i++) {
            ListNode pre = null;
            ListNode tmp = cur;
            int c = 0;
            while (c++ < k) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            if (i != 0) {
                tail.next = pre;
                tail = tmp;
            } else {
                tail = tmp;
                ans = pre;
            }
        }

        if (remainder != 0) {
            if (tail != null) tail.next = cur;
        }

        if (null == ans) ans = head;

        return ans;
    }


}
