# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def swapPairs(self, head):
        if head is None or head.next is None:
            return head

        # pre, cur待swap
        pre = head
        cur = head.next
        next = head.next.next

        cur.next = pre  # exchange
        pre.next = self.swapPairs(next)  # 將next為head的倆倆交換

        return cur
