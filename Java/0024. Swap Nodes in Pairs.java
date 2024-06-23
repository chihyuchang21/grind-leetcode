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

// 起手式: 用改變指針的指向思考

//recursion
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        //獲取下一個節點
        ListNode next = head.next;
        //進行recursion
        ListNode newNode = swapPairs(next.next);
        //在此進行交換
        next.next = head;
        head.next = newNode;

        return next;
    }
}