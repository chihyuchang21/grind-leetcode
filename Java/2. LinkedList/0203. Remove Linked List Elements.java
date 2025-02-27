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
    public ListNode removeElements(ListNode head, int val) {
        // in case if the head.val == val
        ListNode dummyHead = new ListNode(-1, head); // (val,next)
        ListNode cur = head;
        ListNode pre = dummyHead;

        if (head == null) {
            return null;
        }

        while (cur != null) { // itrate the linked list
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}

// 在操作鏈表時，當使用 虛擬頭節點（dummy head node） 後，
// 常常會在最後返回 dummy.next。這是因為虛擬頭節點本身並不屬於真正的鏈表數據，只是一個輔助節點。
// 因此，我們需要返回真正的鏈表頭節點，而這個頭節點是由 dummy.next 指向的。
