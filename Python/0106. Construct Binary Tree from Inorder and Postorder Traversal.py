# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def buildTree(self, inorder, postorder):

        #Step1: 特殊情形討論 - 樹為空、recursion終止條件
        if not postorder:
            return None

        #Step2: postorder的最後一個就是當前的中間節點
        root_val = postorder[-1]
        root = TreeNode(root_val)

        #Step3: 找切割點
        separator_idx = inorder.index(root_val)

        #Step4: 切割inorder數組，得到inorder數組的左,右半邊
        inorder_left = inorder[:separator_idx]
        inorder_right = inorder[separator_idx + 1:]

        #Step5: 切割postorder數組，得到postorder數組的左,右半邊
        #重點: 中序數組大小一定跟後序數組大小是相同的
        postorder_left = postorder[:len(inorder_left)]
        postorder_right = postorder[len(inorder_left): len(postorder) - 1]

        #Step6: Recursion
        root.left = self.buildTree(inorder_left, postorder_left)
        root.right = self.buildTree(inorder_right, postorder_right)

        #Step7: return answer
        return root



