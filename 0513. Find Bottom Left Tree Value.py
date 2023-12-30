# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def findBottomLeftValue(self, root):
        self.max_depth = float('-inf')
        self.result = None
        self.traversal(root,0)
        return self.result

    def traversal(self, node, depth):
        if not node.left and not node.right:
            if depth > self.max_depth:
                self.max_depth = depth
                self.result = node.val
            return

        if node.left:
            self.traversal(node.left, depth + 1)
        if node.right:
            self.traversal(node.right, depth + 1)

