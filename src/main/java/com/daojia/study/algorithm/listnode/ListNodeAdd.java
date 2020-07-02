package com.daojia.study.algorithm.listnode;

import java.util.ArrayList;
import java.util.List;

public class ListNodeAdd {

    /**
     * 无重复最长字串
     *
     * @param s s
     * @return int
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int count = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (list.contains(s.charAt(j))) {
                    break;
                }else {
                    list.add(s.charAt(j));
                }
            }
            count = Math.max(count, list.size());
            list.clear();
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcdfec"));
       /* ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(8);
        ListNode listNode6 = new ListNode(1);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        System.out.println(addTwoNumbers(listNode1, listNode4));*/
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int number = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = number + x + y;
            number = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            if (number == 1) {
                cur.next = new ListNode(number);
            }
        }

        return pre.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
