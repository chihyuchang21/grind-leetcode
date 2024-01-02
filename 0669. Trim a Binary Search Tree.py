# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):
    def trimBST(self, root, low, high):

        if root is None:
            return None

        if root.val < low:
            #找符合區間[low, high]的節點
            return self.trimBST(root.right, low, high)

        if root.val > high:
            return self.trimBST(root.left, low, high)

        root.left = self.trimBST(root.left, low, high) #root.left接入符合條件的左
        root.right = self.trimBST(root.right, low, high) 
        return root