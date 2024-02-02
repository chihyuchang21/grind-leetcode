# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def mergeTrees(self, root1, root2):

        #有節點為空，立刻返回另一個
        if not root1:
            return root2
        if not root2:
            return root1

        #確保至此root1, root2都非空
        root1.val += root2.val #中
        root1.left = self.mergeTrees(root1.left, root2.left)
        root1.right = self.mergeTrees(root1.right, root2.right)

        return root1 #本題重複使用節點，而非創新節點

