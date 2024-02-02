# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#法一: Resursion
class Solution:
    def inorderTraversal(self, root):
        if root is None:
            return []

        left = self.inorderTraversal(root.left)
        right = self.inorderTraversal(root.right)

        return left + [root.val] + right


#法二: Iteration - while loop
class Solution:
    def inorderTraversal(self, root):
        if not root:
            return []
        stack = []
        result = []
        cur = root
        while cur or stack:
            #最底層的左先
            if cur:
                stack.append(cur)
                cur = cur.left
            #處理節點
            else:
                cur = stack.pop()
                result.append(cur.val)
                #右節點
                cur = cur.right
        return result