package com.daojia.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiachao
 * @since 2020/6/2 10:12
 */
public class ListNodeAdd {


    public static void main(String[] args) {


        String s = "adsfsf";
        List<Character>  list = new ArrayList<>();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(l1);
        System.out.println(l2);

        ListNode listNode = add(l1,l2);
        System.out.println("add result=" + listNode);

        ListNode listNode1 = new ListNode(10);
        ListNode listNode2 = listNode1;

        listNode1.next = new ListNode(22);
        listNode2.next.next = new ListNode(23);
        System.out.println(listNode1);
        System.out.println(listNode2);

    }

    private static ListNode add(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int number = 0;
        while (l1!= null || l2 != null) {
            int x = l1 == null ? 0: l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = number + x + y;
            number = sum /10;
            sum = sum%10;
            cur.next = new ListNode(sum);
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
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
