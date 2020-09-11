//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表

package leetCode.leetcode.editor.cn;
public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        solution.reverseBetween(node,0,0);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newNode = new ListNode(head.val);
        newNode.next = null;
        ListNode midNode = head.next;
        ListNode nextNextNode = head.next.next;
        while(null != nextNextNode){
            midNode.next = newNode;
            newNode = midNode;

            midNode = nextNextNode;
            nextNextNode = nextNextNode.next;
        }
        midNode.next = newNode;
        newNode = midNode;
        return newNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}