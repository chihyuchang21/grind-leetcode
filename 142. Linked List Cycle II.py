# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        slow = head
        fast = head

        #If there's a cycle, the slow/fast pts will eventualyl meet.
        
        while fast and fast.next: #fast and fast.next are not None
            slow = slow.next
            fast = fast.next.next

            if slow == fast: #Move one of the pts back to the start of the list

                slow = head
                while slow != fast:
                    slow = slow.next
                    fast = fast.next
                return slow
        
        #If there is no cycle, return None
        return None
