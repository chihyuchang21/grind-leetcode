# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#左小右大，直接取該樹的最小值
class Solution(object):
    def __init__(self):
        self.pre = None #用來記錄前一個節點

    def isValidBST(self, root):
        
        if root is None:
            return True

        left = self.isValidBST(root.left)

        if self.pre is not None and self.pre.val >= root.val:
            return False
        self.pre = root

        right = self.isValidBST(root.right)
        return left and right

