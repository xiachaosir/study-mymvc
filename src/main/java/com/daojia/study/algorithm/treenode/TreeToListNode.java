package com.daojia.study.algorithm.treenode;

/**
 * @author xiachao
 * @since 2020/7/2 18:23
 */
public class TreeToListNode {

    private static NodeOp nodeOp = new NodeOp();

    static class NodeOp {
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
    }

    //后序
    public static void behindTraverse(TreeNode root) {
        if (root != null) {
            behindTraverse(root.getLeft());
            behindTraverse(root.getRight());
            nodeOp.add(root.getValue() + "");
        }
    }

    public static void main(String[] args) {
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);

        behindTraverse(A);
        nodeOp.first.prev = nodeOp.last;
        nodeOp.last.next = nodeOp.first;
        System.out.println(nodeOp.first.getData());
    }

}
