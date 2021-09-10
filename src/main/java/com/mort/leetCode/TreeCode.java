package com.mort.leetCode;


import com.mort.leetCode.leetcode.editor.cn.TreeNode;
import com.mort.leetCode.leetcode.editor.cn.TreeNode;

public class TreeCode {


    public TreeNode treeInvert(TreeNode node) {

        if (null == node || null == node.getLeft() || null == node.getRight()) {
            return node;
        }

        TreeNode left = treeInvert(node.getLeft());
        TreeNode right = treeInvert(node.getRight());
        node.setLeft(right);
        node.setRight(left);
        return node;
    }


    public static void main(String[] args) {

    }

}
