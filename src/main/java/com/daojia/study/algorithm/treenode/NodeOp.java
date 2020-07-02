package com.daojia.study.algorithm.treenode;

/**
 * @author xiachao
 * @since 2020/7/2 17:41
 */
public class NodeOp {

    private Node first;

    private Node last;

    public boolean add(String data) {
        Node newNode = new Node(this.last, data, null);
        if (this.first == null) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
        return true;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
}
