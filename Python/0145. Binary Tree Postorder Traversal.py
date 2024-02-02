# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#法一: Resursion
class Solution:
    def postorderTraversal(self, root):
        if not root:
            return []

        left = self.postorderTraversal(root.left)
        right = self.postorderTraversal(root.right)

        return left + right + [root.val]

#法二: Iteration - while loop
class Solution:
    def postorderTraversal(self, root):
        if not root:
            return []
        stack = [root]
        result = []
        while stack:
            node = stack.pop()
            #中結點先處理
            result.append(node.val)
            #左先入
            if node.left:
                stack.append(node.left)
            #右再入
            if node.right:
                stack.append(node.right)
            #最後反轉
        return result[::-1]