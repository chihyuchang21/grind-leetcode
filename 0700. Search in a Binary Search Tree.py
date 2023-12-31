# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

#法一: recursion
class Solution(object):
    def searchBST(self, root, val):
        #搜索到目標節點就要立即return(若不加就是traverse整棵樹)

        if not root or root.val == val:
            return root

        if root.val > val:
            return self.searchBST(root.left, val)

        if root.val < val:
            return self.searchBST(root.right, val)

#法二: iteration
class Solution(object):
    def searchBST(self, root, val):
        while root:
            if val < root.val:
                root = root.left

            elif val > root.val:
                root = root.right

            else: return root

        return None
