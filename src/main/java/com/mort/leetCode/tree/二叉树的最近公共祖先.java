package com.mort.leetCode.tree;

import com.mort.leetCode.leetcode.editor.cn.TreeNode;

public class 二叉树的最近公共祖先 {

    /**
     * 寻找二叉树中两个节点的最近公共祖先
     *
     * @param root 根节点
     * @param p 节点p
     * @param q 节点q
     * @return 最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 基本情况：如果根节点为空，或者根节点就是p或q，则返回根节点
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归查找左子树中p和q的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.getLeft(), p, q);

        // 递归查找右子树中p和q的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.getRight(), p, q);

        // 如果左右子树都找到了节点，说明当前根节点就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 如果只有左子树找到了节点，返回左子树的结果
        if (left != null) {
            return left;
        }

        // 如果只有右子树找到了节点，返回右子树的结果
        if (right != null) {
            return right;
        }

        // 如果都没找到，返回null
        return null;
    }

}
