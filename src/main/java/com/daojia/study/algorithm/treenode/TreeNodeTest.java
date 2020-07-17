package com.daojia.study.algorithm.treenode;

import java.util.*;

/**
 * @author xiachao
 * @since 2020/6/10 16:20
 */
public class TreeNodeTest {

    private static List<Integer> dataList = new LinkedList<>();

    private static NodeOp nodeOp = new NodeOp();

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

    /**
     * 前序 ： 根 左 右
     * 中序 ： 左 根 右
     * 后序 ： 左 右 根
     */

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
            behindTraverse(root.getLeft());
            behindTraverse(root.getRight());
            System.out.print(root.getValue() + ">");
            nodeOp.add(root.getValue() + "");
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

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode last = root;  //表示当前遍历层最右结点
        TreeNode nlast = root; //表示下一层最右结点
        //遍历时，每次将nlast指向插入队列元素，最后一个插入结点时即最右结点。
        // 插入左右孩子之后，检测last是否为当前输出结点，若是，则表示需要进行换行，并将last指向下一层的nlast。
        while (!queue.isEmpty()) {
            TreeNode t = queue.peek();
            System.out.print(queue.poll().getValue() + " ");
            if (t.getLeft() != null) {
                queue.add(t.getLeft());
                nlast = t.getLeft();
            }
            if (t.getRight() != null) {
                queue.add(t.getRight());
                nlast = t.getRight();
            }
            // 如果当前输出结点是最右结点，那么换行
            if (last == t) {
                System.out.println();
                last = nlast;
            }
        }
    }

    // 获取最大宽度
    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队
        int count = 0;

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点1122
                TreeNode t = queue.poll();
                len--;
                if (t.getLeft() != null)
                    queue.add(t.getLeft()); // 下一层节点入队
                if (t.getRight() != null)
                    queue.add(t.getRight());// 下一层节点入队
            }
            count++;
            if(count == 2) {
                System.out.println("第二层节点数=" + count);
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodeTest.init();
        printTree(root);
        /*System.out.println(root);
        frontTraverse(root);
        System.out.println("");
        middleTraverse(root);
        System.out.println("");*/

        System.out.println(getMaxWidth(root));

        behindTraverse(root);
        System.out.println("-----");
        for (int i = 0; i < dataList.size(); i++) {
            System.out.print(dataList.get(i));
        }
        nodeOp.getFirst().prev = nodeOp.getLast();
        nodeOp.getLast().next = nodeOp.getFirst();

        System.out.println(nodeOp.getFirst().getData());

        //System.out.println(nodeOp);

        /*System.out.println(dl.getFirst());
        System.out.println("");*/
        //levelOrderTraverse(root);

    }


}
