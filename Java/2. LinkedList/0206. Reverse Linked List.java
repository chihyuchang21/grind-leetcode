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
        while (cur != null) {
            temp = cur.next; //保存下一個節點
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // 2nd 240627
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next; // 先儲存 cur 要往前的位置
            cur.next = prev; // 改變指向
            prev = cur; // prev 指針往前
            cur = temp; // cur 再往前
        }
        return prev;
    }

    // 3rd 240708

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode temp = null;

            while (cur != null) {
                temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            return prev;
        }
    }

    // 4th 240930
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;  // 用來保存當前節點的前一個節點，最開始為 null，表示反轉後的最後一個節點
            ListNode cur = head;   // 用來遍歷鏈表的當前節點，從 head 開始
            ListNode temp = null;  // 用來臨時保存當前節點的下一個節點，以免反轉過程中丟失鏈表

            // 遍歷整個鏈表，直到 cur 變為 null（即鏈表末尾）
            while (cur != null) {
                temp = cur.next;   // 保存當前節點的下一個節點
                cur.next = prev;   // 反轉鏈接：將當前節點的 next 指向它的前一個節點
                prev = cur;        // 移動 prev 到當前節點，準備下一次反轉
                cur = temp;        // 移動 cur 到下一個節點（即剛才存的 temp）
            }

            // 當所有節點反轉後，prev 會指向反轉後的頭節點，因此返回 prev
            return prev;
        }
    }
}