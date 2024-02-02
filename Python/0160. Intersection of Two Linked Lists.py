# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        lenA, lenB = 0,0
        cur = headA
        
        while cur: #求lenA的長度
            cur = cur.next
            lenA += 1
        cur = headB

        while cur: #求lenB的長度
            cur = cur.next
            lenB += 1
        curA, curB = headA,headB 

        if lenA > lenB: #使curB為最長len的頭，lenB為其長度
            curA, curB = curB, curA
            lenA, lenB = lenB, lenA

        for i in range(lenB-lenA): #讓curA, curB在同一起點上(末尾位置對齊)  
            curB = curB.next
        while curA:
            if curA == curB:
                return curA
            else:
                curA = curA.next
                curB = curB.next
        return None        
        
