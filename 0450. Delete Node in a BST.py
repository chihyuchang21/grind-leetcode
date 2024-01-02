# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def deleteNode(self, root, key):

        if root is None:
            return root

        if root.val == key: #找到要刪除的節點

            if root.right is None: #右子樹為空，直接返回左子樹作新的根節點
                return root.left

            cur = root.right

            while cur.left:
                cur = cur.left
            root.val, cur.val = cur.val, root.val #要刪除的與最左節點交換

        root.left = self.deleteNode(root.left, key) #左子樹中遞迴刪除目標節點
        root.right = self.deleteNode(root.right, key) #右子樹中遞迴刪除目標節點
        return root

