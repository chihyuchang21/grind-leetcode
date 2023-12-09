# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#define new Linkedlist浪費內存空間
#先定義cur指針，指向head、再定義pre指針，initialize為null
#把cur -> next節點用temp指針保存，將其反轉為指向pre並cycle
#Two-Pointer Method

class Solution(object):
    def reverseList(self, head):
        cur = head
        pre = None
        while cur:
            temp = cur.next #cur的下一個節點要反轉為pre
            cur.next = pre

            #updata pre & cur pointer
            pre = cur
            cur = temp
        return pre
