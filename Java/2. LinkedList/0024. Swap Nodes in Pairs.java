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

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead = new ListNode(-1); // dummy head
        dummyhead.next = head;
        ListNode cur = dummyhead;
        ListNode temp; // 用於保存兩個節點後面的節點
        ListNode firstNode;
        ListNode secondNode;

        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;  // Step 1
            secondNode.next = firstNode; // Step 2
            firstNode.next = temp; // Step 3
            cur = firstNode; // move cur for next round exchange
        }
        return dummyhead.next;
    }
}