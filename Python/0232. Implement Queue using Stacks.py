class MyQueue(object):

    def __init__(self):
        """
        in主要負責push, out主要負責pop
        """
        self.stack_in = []
        self.stack_out = []


    def push(self, x):
        """
        有新element進來，就往in裡面push
        """
        self.stack_in.append(x)


    def pop(self):
        """
        Removes the element from in front of queue and returns that elements
        """
        if self.empty():
            return None

        if self.stack_out:
            return self.stack_out.pop()
        else:
            for i in range(len(self.stack_in)):
                self.stack_out.append(self.stack_in.pop())
            return self.stack_out.pop()



    def peek(self):
        """
        Get the front element
        """
        ans = self.pop()
        self.stack_out.append(ans)
        return ans


    def empty(self):
        """
        只要in/out有element，說明隊列不為空
        """
        return not(self.stack_in or self.stack_out)



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()