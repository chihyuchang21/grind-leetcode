# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#法一: Resursion
class Solution:
    def preorderTraversal(self, root):
        if not root:
            return []

        left = self.preorderTraversal(root.left)
        right = self.preorderTraversal(root.right)

        return [root.val] + left + right


#法二: Iteration - while loop
class Solution:
    def preorderTraversal(self, root):
        if not root:
            return []

        stack = [root]
        result = []

        while stack:
            node = stack.pop()
            #中結點先處理
            result.append(node.val)
            #右先放入
            if node.right:
                stack.append(node.right)
            #左後放
            if node.left:
                stack.append(node.left)
        return result
