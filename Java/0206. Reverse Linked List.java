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

// 若再 define 一個 新的 Linked List 是對內存空間的浪費
// 只要改變 next 指針的指向，反轉即可
// 先定義一個 cur 指針指向 head，再定義一個 pre 指針初始化為 null，把 cur -> next 用 temp 保存

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