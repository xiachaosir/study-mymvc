package com.daojia.study.algorithm;

import java.util.PriorityQueue;

public class KthLargest {
    private  PriorityQueue<Integer> pri_queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        //将k赋值给类的全局变量
        this.k = k;
        //创建一个大小为k的优先队列
        pri_queue = new PriorityQueue<>(k);
        for (int val : nums) {
            add(val);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,5};
        KthLargest kthLargest = new KthLargest(2, a);
        System.out.println(kthLargest.getPri_queue().poll());
    }

    public int add(int val) {
        //如果pri_queue没有满
        if (pri_queue.size() < k) {
            //直接将val加入队列，并调整
            pri_queue.offer(val);
        }
        //如果堆顶元素小于val
        else if (pri_queue.peek() < val) {
            //弹出堆顶元素
            pri_queue.poll();
            //加入val并调整
            pri_queue.offer(val);
        }

        //返回堆顶元素
        return pri_queue.peek();
    }

    public PriorityQueue<Integer> getPri_queue() {
        return pri_queue;
    }

    public void setPri_queue(PriorityQueue<Integer> pri_queue) {
        this.pri_queue = pri_queue;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
