/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. 找到鏈表的中間節點 (快慢指針)
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 反轉後半部分鏈表
        ListNode second = slow.next;
        slow.next = null; // 將前後鏈表分開
        ListNode prev = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // 3. 合併兩個鏈表
        ListNode first = head, secondReversed = prev;
        while (secondReversed != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = secondReversed.next;
            first.next = secondReversed; // 插入節點
            secondReversed.next = tmp1; // 連接原鏈表
            first = tmp1;
            secondReversed = tmp2;
        }
    }
}
