package com.daojia.study.algorithm.treenode;

/**
 * @author xiachao
 * @since 2020/7/2 17:37
 */
public class Node {

    public Node prev;
    public String data;
    public Node next;

    public Node(Node prev, String data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
