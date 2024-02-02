# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def convertBST(self, root):

        if not root:
            return root

        stack = []
        result = []
        cur = root
        pre = 0

        while cur or stack:
            if cur:
                stack.append(cur)
                cur = cur.right
            else:
                cur = stack.pop()
                cur.val += pre
                pre = cur.val
                cur = cur.left
        return root
