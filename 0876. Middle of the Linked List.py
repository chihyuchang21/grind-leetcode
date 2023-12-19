# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#法1: 2 Loop
class Solution(object):
    def middleNode(self, head):
        ptr = head
        count = 0
        while (ptr):
            count+=1
            ptr= ptr.next
          
        times = count//2
        ptr = head
        while (times):
            times-=1
            ptr = ptr.next
        
        return ptr


#法2: 快慢指針
class Solution(object):
    def middleNode(self, head):
        slow = head
        fast = head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        return slow

#這樣的修改使用了兩個指針，一個慢指針 slow，一個快指針 fast。slow 每次前進一步，
而 fast 每次前進兩步。當 fast 到達鏈表尾部時，slow 就會指向中點。這種方法避免了計算鏈表長度的需要，同時減少了遍歷的次數。
