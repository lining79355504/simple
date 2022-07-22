package com.mort.leetCode.tree;

import java.math.BigDecimal;

/**
 * @author mort
 * @Description
 * @date 2021/10/9
 * <p>
 * 是否完全对称对称二叉树
 **/
public class IsSymmetryTree {


    public static boolean isSymmetryTree(BinaryTree left, BinaryTree right) {
        if (null == left && null == right) {
            return true;
        }

        if (null == left || null == right) {
            return false;
        }

        if (left.value != right.value) {
            return false;
        }

        return isSymmetryTree(left.getLeft(), left.getRight()) && isSymmetryTree(right.getLeft(), right.getRight());
    }


    public static void main(String[] args) {


    }

}
