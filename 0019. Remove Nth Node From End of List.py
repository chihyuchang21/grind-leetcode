# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def removeNthFromEnd(self, head, n):
        #Create a dummy head
        dummy_head = ListNode(0, head)

        #Initialize 2 pointers as dummy_head
        slow = fast = dummy_head

        #f is faster then s (n+1)
        for i in range(n+1):
            fast = fast.next
        
        #moving 2 pointers, until fast reach the end of Linkedlist
        while fast:
            slow = slow.next
            fast = fast.next
        
        #update (n-1) node.next to delect Nth node
        slow.next = slow.next.next

        return dummy_head.next
