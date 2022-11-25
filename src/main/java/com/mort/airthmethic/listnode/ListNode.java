package com.mort.airthmethic.listnode;


import java.util.ArrayList;
import java.util.List;

/**
 * 单链表 （有环， 无环）
 */
public class ListNode {

    public int val;

    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode node) {
        this.val = val;
        next = node;
    }

    public static ListNode newInstance(int[] arr) {
        ListNode result = new ListNode(arr[0]);
        ListNode tmp = result;
        for (int i = 1; i < arr.length; i++) {
            //环形链表设置
            ListNode ringTmp = result;
            while (null != ringTmp) {
                if (arr[i] == ringTmp.val) {
                    tmp.next = ringTmp;
                    return result;
                }
                ringTmp = ringTmp.next;
            }

            //非环形逻辑
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return result;
    }

    public static void printData(ListNode data) {
        if (null != data) {
            System.out.println("data = " + data.val + ",");
            printData(data.next);
        }
    }

    //有环 无环均可转化为list
    public static List<Integer> toList(ListNode data) {
        ListNode tmp = data;
        List<Integer> result = new ArrayList<>();
        while (null != tmp && !result.contains(tmp.val)) {
            result.add(tmp.val);
            tmp = tmp.next;
        }
        //环形链表添加重复节点
        if (null != tmp) {
            result.add(tmp.val);
        }
        return result;
    }


    public static void main(String[] args) {
//        int[] data = new int[4];
        int[] data = {3, 2, 0, -4};
        ListNode listNode = newInstance(data);
        List<Integer> list = toList(listNode);

        int[] ringData = {3, 2, 0, -4, 2};
        ListNode ringListNode = newInstance(ringData);
        List<Integer> ringList = toList(ringListNode);
    }
}
