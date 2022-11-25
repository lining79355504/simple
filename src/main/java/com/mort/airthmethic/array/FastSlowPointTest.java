package com.mort.airthmethic.array;

import com.mort.airthmethic.listnode.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @author mort
 * @Description
 * @date 2022/11/25
 **/
public class FastSlowPointTest {


    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     */

    public ListNode midNodeReturn(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Test
    public void run(){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        midNodeReturn(listNode);
    }
}
