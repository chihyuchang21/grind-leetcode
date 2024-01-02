# Definition for a binary tree node.
 class TreeNode(object):
     def __init__(self, val=0, left=None, right=None):
         self.val = val
        self.left = left
         self.right = right


class Solution(object):

    def traversal(self, nums, left, right):
        if left > right:
            return None

        mid = left + (right - left) // 2
        root = TreeNode(nums[mid])
        root.left = self.traversal(nums, left, mid - 1)
        root.right = self.traversal(nums, mid + 1, right)
        return root

    def sortedArrayToBST(self, nums):
        root = self.traversal(nums, 0, len(nums) - 1)
        return root

