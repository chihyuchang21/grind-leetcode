//We can use 2 pts and recursion
//2 pts

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null){
            temp = cur.next; //保存下一個節點
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}