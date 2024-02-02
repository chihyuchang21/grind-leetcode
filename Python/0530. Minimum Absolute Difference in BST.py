# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):
    def __init__(self):
        self.vec = []

    def traversal(self, root):
        if root is None:
            return
        self.traversal(root.left)
        self.vec.append(root.val) #將BST轉換為有序數組
        self.traversal(root.right)

    def getMinimumDifference(self, root):

        self.vec = []
        self.traversal(root)

        if len(self.vec) < 2:
            return 0

        result = float('inf')

        for i in range(1, len(self.vec)):
            #統計array的最小差值
            result = min(result, self.vec[i] - self.vec[i - 1])
        return result

