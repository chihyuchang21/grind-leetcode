from operator import add, sub, mul #簡化程式碼/避免命名衝突

class Solution:
    #Create Dictionary
    op_map = {'+':add, '-':sub, '*':mul,'/': lambda x,y: int(x / y)} #lambda用法

    def evalRPN(self, tokens):
        stack = []
        for token in tokens:
            if token not in {'+', '-', '*', '/'}:
                stack.append(int(token))
            else:
                op2 = stack.pop()
                op1 = stack.pop()
                if token =='/' and op1 * op2 < 0: #記得加上特殊處理負數的情況
                    stack.append(int(float(op1) / op2))
                else:
                    stack.append(self.op_map[token](op1, op2)) #第一個出來的在運算符後面
        return stack.pop()
