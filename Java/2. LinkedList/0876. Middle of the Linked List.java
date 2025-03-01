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

// dummy -> 1 -> 2 -> (3) -> 4 -> 5 -> null
// dummy -> 1 -> 2 -> 3 -> (4) -> 5 -> 6 -> null

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1, head);
        ListNode right = dummyHead;
        ListNode left = dummyHead;
        int listLength = 0;

        // length of head?
        while (head != null) {
            listLength += 1;
            head = head.next;
        }

        // System.out.println(listLength);

        int mid = listLength / 2;  // Since index starts from 0

        // Move `right` to the middle node
        for (int i = 0; i < mid; i++) {
            right = right.next;
        }

        return right.next;  // `right` is still at dummyHead, so return `right.next`
    }
}