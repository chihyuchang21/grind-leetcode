# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):
    def isBalanced(self, root):
        if self.get_height(root) != -1:
            return True
        else:
            return False

    def get_height(self, root):

        # Base Case
        if not root:
            return 0

        # 左
        left_height = self.get_height(root.left)
        if left_height == -1:
            return -1

        # 右
        right_height = self.get_height(root.right)
        if right_height == -1:
            return -1

        # 中
        if abs(left_height - right_height) > 1:
            return -1
        else:
            return 1 + max(left_height, right_height)
