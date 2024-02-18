/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//合併鏈表實現同步移動
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //p1指向A鏈表頭結點，p2指向B鏈表頭結點
        ListNode p1 =  headA, p2 = headB;
        while (p1 != p2){
            //p1走一步，如果走到A鏈表末尾，轉到B鏈表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            //p2走一步，如果走到B鏈表末尾，轉到A鏈表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}