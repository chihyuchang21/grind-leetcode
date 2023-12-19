from collections import deque
class MyStack(object):

    def __init__(self):
        """
        in:存所有數據
        out: 只有在pop時會用到
        """
        self.queue_in = deque()
        self.queue_out = deque()

    def push(self, x):
        """
        直接append即可
        """
        self.queue_in.append(x)


    def pop(self):
        """
        1.先確認不為空
        2.Queue為FIFO，只有在pop()時才會使用queue_out
        3.先把queue_in中的所有elements(除了final one)，依序出列放進queue_out
        4.交換in和out，此時out只有 1 element
        5.把out中的pop出來，即是原隊列的最後一個
        """
        if self.empty():
            return None

        for i in range(len(self.queue_in) - 1):
            self.queue_out.append(self.queue_in.popleft())

        self.queue_in, self.queue_out = self.queue_out, self.queue_in #交換in & out，in只用來存
        return self.queue_out.popleft()


    def top(self):
        """
        1.先確認不為空
        2.只有in存放數據，return第一個即可(用到stack(
        """
        if self.empty():
            return None

        return self.queue_in[-1] #直接獲取queue末個元素


    def empty(self):
        """
        只有in存數據，只要判斷in是不是有數即可
        """
        return len(self.queue_in) == 0



# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()