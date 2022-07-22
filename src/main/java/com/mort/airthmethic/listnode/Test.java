package com.mort.airthmethic.listnode;

import com.mort.airthmethic.listnode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mort
 * @Description
 * @date 2022/3/7
 **/
public class Test {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public static boolean isCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode first = head, second = head.next;
        while (true) {
            if (null == second || null == second.next) {
                System.out.println("no ring");
                return false;
            }

            if (first.val == second.val) {
                //has ring return first ring node
                return true;
            }
            first = first.next;
            second = second.next.next;
        }
    }

//    /**
//     * 返回环形链表的第一个环节点
//     * 非环形链表返回null
//     *
//     * @param head
//     * @return
//     */
//    public static ListNode detectCycle(ListNode head) {
//        Set<Integer> valSet = new HashSet<>();
//        ListNode tmp = head;
//        while (null != tmp) {
//            if (valSet.contains(tmp.val)) {
//                return tmp;
//            }
//            valSet.add(tmp.val);
//            tmp = tmp.next;
//        }
//        return null;
//    }

    /**
     * 返回环形链表的第一个环节点
     * 非环形链表返回null
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        Set<Integer> valSet = new HashSet<>();
        ListNode tmp = head;
        while (null != tmp) {
            if (valSet.contains(tmp.val)) {
                //获取环节点
                ListNode tmpBeta = head;
                while (null != tmpBeta) {
                    if (tmpBeta.val == tmp.val) {
                        return tmpBeta;
                    }
                    tmpBeta = tmpBeta.next;
                }
            }
            valSet.add(tmp.val);
            tmp = tmp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] data = {3, 2, 0, -4};
        ListNode listNode = ListNode.newInstance(data);
        detectCycle(listNode);

//        int[] dataRing = {3, 2, 0, -4, 2};
        int[] dataRing = {-1, -7, 7, -4, 19, 6, -9, -5, -2, -5};
        ListNode ringListNode = ListNode.newInstance(dataRing);
        detectCycle(ringListNode);
    }
}
