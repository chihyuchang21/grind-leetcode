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

// 01. recursion，沒把握
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
           if (list1.val < list2.val) {
               list1.next = mergeTwoLists(list1.next, list2);
               return list1;
           } else {
               list2.next = mergeTwoLists(list1, list2.next);
               return list2;
           }
        }
        if (list1 == null)
            return list2;
        return list1;
    }
}

// 02. iteration (while loop)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1); // initialization
        ListNode cur = prehead;

        while (list1 != null && list2 != null) { // null -> 裡面沒東西、iterate 完畢
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // 還有沒 iterate 完的 element
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }

        return prehead.next;
    }
}