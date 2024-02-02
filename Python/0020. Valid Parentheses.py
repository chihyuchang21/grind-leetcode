#使用stack比dictionary省空間
#append它的另一半進去，酷

class Solution:
    def isValid(self,s):
        stack = []

        for item in s:
            if item == '(':
                stack.append(')')
            elif item == '{':
                stack.append('}')
            elif item == '[':
                stack.append(']')
            elif not stack or stack[-1] != item:
                return False
            else:
                stack.pop()

        return True if not stack else False




