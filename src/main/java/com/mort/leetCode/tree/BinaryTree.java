package com.mort.leetCode.tree;

/**
 * @author mort
 * @Description
 * @date 2021/10/9
 **/
public class BinaryTree {
    private BinaryTree left;

    private BinaryTree right;

    public Object value;


    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
