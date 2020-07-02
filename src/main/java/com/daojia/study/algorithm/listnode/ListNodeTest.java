package com.daojia.study.algorithm.listnode;

/**
 * @author xiachao
 * @since 2020/4/20 16:46
 */
public class ListNodeTest {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(9);
        listNode5.next = listNode6;

        System.out.println(listNode1);
        System.out.println(listNode5);
        //System.out.println(mergeTwoLists(listNode1, listNode5));

        System.out.println("---------------------");

        //System.out.println(hebingNode(listNode1, listNode5));
        System.out.println("---------------------");

        System.out.println(hebingNode(listNode1, listNode5));

    }

    public static ListNode hebingNode(ListNode l1, ListNode l2) {
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
     * 递归方式合并有序链表
     *
     * @param l1 l1
     * @param l2 l2
     * @return listnode
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }


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
