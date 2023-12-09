class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class MyLinkedList(object):
    def __init__(self):
        self.dummy_head = ListNode()
        self.size = 0

    
    def get(self, index):
        if index < 0 or index >= self.size:
            return -1

        current = self.dummy_head.next
        for i in range(index):
            if current.next:
                current = current.next
            else:
                return -1  # Handle the case where the index is out of bounds

        return current.val
        

    def addAtHead(self, val):
        self.dummy_head.next = ListNode(val, self.dummy_head.next)
        self.size += 1
        

    def addAtTail(self, val):
        current = self.dummy_head
        while current.next:
            current = current.next
        current.next = ListNode(val)
        self.size += 1
        
        

    def addAtIndex(self, index, val):
        if index < 0 or index > self.size:
            return
        
        current = self.dummy_head
        for i in range(index):
            current = current.next
        current.next = ListNode(val, current.next)
        self.size += 1
        

    def deleteAtIndex(self, index):
        if index < 0 or index >= self.size:
            return
        
        current = self.dummy_head
        for i in range(index):
            current = current.next
        current.next = current.next.next
        self.size -= 1
