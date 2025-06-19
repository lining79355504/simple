package com.mort.airthmethic.tree;

import com.mort.leetCode.leetcode.editor.cn.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    //是否完全二叉树
    public boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean seenNull = false;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                seenNull = true;
            } else {
                if (seenNull) {
                    return false; // 如果之前已经见过null节点，现在又遇到非null节点，说明不是完全二叉树
                }
                queue.offer(current.getLeft());
                queue.offer(current.getRight());
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // 测试代码可以在这里添加
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));

        Tree tree = new Tree();
        System.out.println(tree.isCompleteBinaryTree(root)); // 输出 true
    }
}
