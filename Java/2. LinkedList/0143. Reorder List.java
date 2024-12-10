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
        // 若鏈表為空或只有一個節點，則不需要處理
        if (head == null || head.next == null) return;

        // 步驟 1: 使用快慢指針找到中間節點
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;  // 慢指針每次走一步
            fast = fast.next.next;  // 快指針每次走兩步
        }

        // 步驟 2: 反轉後半部分鏈表
        ListNode second = slow.next;  // second 指向後半部分
        slow.next = null;  // 將前半部分和後半部分斷開
        ListNode prev = null;  // 用來反轉後半部分的指針
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;  // 反轉指針
            prev = second;
            second = tmp;
        }

        // 現在 prev 指向的是反轉後的後半部分的頭
        ListNode first = head, secondReversed = prev;

        // 步驟 3: 交替合併前後兩部分
        while (secondReversed != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = secondReversed.next;

            first.next = secondReversed;  // 將 secondReversed 插入 first 之後
            secondReversed.next = tmp1;   // 將原來的 first.next 接到 secondReversed 之後

            first = tmp1;  // first 移動到下一個節點
            secondReversed = tmp2;  // secondReversed 移動到下一個節點
        }
    }
}

