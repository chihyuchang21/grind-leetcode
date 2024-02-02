from collections import deque

class MyQueue: #Monotonic Queue(從大到小
    def __init__(self):
        self.queue = deque() #若用list會超時

    #每次pop時，比較目前要pop的數是否=front element of the queue，相等則彈出
    def pop(self, value):
        if self.queue and value == self.queue[0]: #pop前先判斷queue是否為空
            self.queue.popleft()

    #如果push的數字>front element of the queue，將後端彈出直到push value <= 它
    #保持Monotonic Queue(從大到小
    def push(self, value):
        while self.queue and value > self.queue[-1]:
            self.queue.pop()
        self.queue.append(value)

    #查詢最大值(front)
    def front(self):
        return self.queue[0]

class Solution:
    def maxSlidingWindow(self, nums, k):
        que = MyQueue()
        result = []

        for i in range(k): #先將前k的elements放進queue
            que.push(nums[i])
        result.append(que.front()) #result記錄前k elements的max

        for i in range(k, len(nums)):
            que.pop(nums[i - k]) #移除最前面的元素
            que.push(nums[i]) #加入最後面的元素
            result.append(que.front()) #紀錄對應的max
        return result


