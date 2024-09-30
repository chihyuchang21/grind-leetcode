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


// Practice Definition of Linked List
//public class ListNode {
//    int val;
//    ListNode next;
//
//    public ListNode(){
//    }
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//
//    public ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

// 移除 head 跟移除 others 作法不同，要統一方法則設置 dummy head
// 類似快慢指針


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1, head); // dummy head // -1 -> value (這裡可以是任何值) ; head -> 指向下一個節點的指針
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

// 2nd 240623
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 設置虛擬指針放在最前面
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {   // head 所指的值 = val (target 的話)
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

// 在操作鏈表時，當使用 虛擬頭節點（dummy head node） 後，
// 常常會在最後返回 dummy.next。這是因為虛擬頭節點本身並不屬於真正的鏈表數據，只是一個輔助節點。
// 因此，我們需要返回真正的鏈表頭節點，而這個頭節點是由 dummy.next 指向的。
