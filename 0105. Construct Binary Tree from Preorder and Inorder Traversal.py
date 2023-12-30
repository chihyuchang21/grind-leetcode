# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def buildTree(self, preorder, inorder):
        # Step 1: 特殊情況討論-樹為空，或recursion終止條件
        if not preorder:
            return None

        # Step 2: preorder的第一個就是目前的中間節點
        root_val = preorder[0]
        root = TreeNode(root_val)

        # Step 3: 找切割點
        separator_idx = inorder.index(root_val)

        # Step 4: 切割inorder數組，得到inorder數組的左右半邊
        inorder_left = inorder[:separator_idx]
        inorder_right = inorder[separator_idx + 1:]

        # Step 5: 切割preorder數組，得到preorder數組的左右半邊
        # 重點: inorder數組大小跟preorder是相同的
        preorder_left = preorder[1:1 + len(inorder_left)]
        preorder_right = preorder[1 + len(inorder_left):]

        # Step 6: recursion
        root.left = self.buildTree(preorder_left, inorder_left)
        root.right = self.buildTree(preorder_right, inorder_right)

        # Step 7: return Ans
        return root