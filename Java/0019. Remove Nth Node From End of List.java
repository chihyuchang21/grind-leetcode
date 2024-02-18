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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        // 移動 fastIndex，直到它指向第 n 個節點
        for (int i = 0; i <= n; i++) {
            if (fastIndex == null) {
                // 處理 n 大於鏈表長度的情况
                return head;
            }
            fastIndex = fastIndex.next;
        }

        // 同時移動 fastIndex 和 slowIndex，直到 fastIndex 到達末尾
        while (fastIndex != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        // 刪除第 n 個節點
        slowIndex.next = slowIndex.next.next;

        return dummyNode.next;
    }
}
