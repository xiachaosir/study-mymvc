package com.daojia.study.algorithm.treenode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author xiachao
 * @since 2020/6/10 16:20
 */
public class TreeNodeTest {

    public void preOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.getValue() + "->");
                stack.push(node);
                node = node.getLeft();
            } else {
                TreeNode tem = stack.pop();
                node = tem.getRight();
            }
        }
    }

    public static TreeNode init() {// 注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        return A;
    }

    //前序
    public static void frontTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.getValue() + ">");
            frontTraverse(root.getLeft());
            frontTraverse(root.getRight());
        }
    }

    //中序
    public static void middleTraverse(TreeNode root) {
        if (root != null) {
            frontTraverse(root.getLeft());
            System.out.print(root.getValue() + ">");
            frontTraverse(root.getRight());
        }
    }

    //后序
    public static void behindTraverse(TreeNode root) {
        if (root != null) {
            frontTraverse(root.getLeft());
            frontTraverse(root.getRight());
            System.out.print(root.getValue() + ">");
        }
    }

    //层次
    public static void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.getValue() + "->");
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodeTest.init();
        System.out.println(root);
        frontTraverse(root);
        System.out.println("");
        middleTraverse(root);
        System.out.println("");
        behindTraverse(root);
        System.out.println("");
        levelOrderTraverse(root);

    }


}
