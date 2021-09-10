package com.mort.leetCode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author:  lining17
 * Date :  2020-05-09
 */
public class TreeTest {

    private static final Logger logger = LoggerFactory.getLogger(TreeTest.class);

    private static TreeNode<Integer> TREE = new TreeNode();

    static {
        TREE = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TREE.left = node2;
        TREE.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node3.right = node6;
    }




    private void treeChangeNode(TreeNode tree){


    }

    //查找树的深度
    private int findDeep(TreeNode tree) {

        if (null != tree) {
            TreeNode left = tree.getLeft();
            TreeNode right = tree.getRight();
            int leftDeep = findDeep(left);
            int rightDeep = findDeep(right);
            return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
        }
        return 0;
    }


    private void foreach(TreeNode tree) {
        if (null != tree) {
            foreach(tree.getLeft());
            foreach(tree.getRight());
            System.out.println("value = [" + tree.getValue() + "]");
        }

        return;
    }

    private TreeNode find(TreeNode tree, Object value) {
        if (null != tree) {
            if (tree.getValue().equals(value)) {
                logger.info("{}",tree);
            }
            find(tree.getLeft(), value);
            find(tree.getRight(), value);
        }
        return null;
    }


    private TreeNode find(int key, int value) {

        TreeNode<Integer> left = TREE.getLeft();
        TreeNode<Integer> right = TREE.getRight();
        if (null != left) {
            if (value < left.getValue()) {
                foreach(left);
            } else {
                if (left.getValue() == value) {
                    return left;
                }
                if (right.getValue() == value) {
                    return right;
                }
            }
        }
        return null;
    }


    private void insert(int key, int value){


    }

    @Test
    public void test(){
        findDeep(TREE);
        find(TREE,3);
    }



    private static class TreeNode<T> {

        private T value;

        private TreeNode<T> left;

        private TreeNode<T> right;

        public TreeNode() {

        }

        public TreeNode(T value) {
            this.value = value;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


}
