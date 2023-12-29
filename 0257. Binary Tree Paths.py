# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def traversal(self, cur, path, result):
        path.append(cur.val) #中

        if not cur.left and not cur.right: #到達葉子節點
            sPath = '->'.join(map(str, path))
            result.append(sPath)
            return

        if cur.left: #左
            self.traversal(cur.left, path, result)
            path.pop()

        if cur.right: #右
            self.traversal(cur.right, path, result)
            path.pop() #回溯

    def binaryTreePaths(self, root):
        result = []
        path = []

        if not root:
            return result

        self.traversal(root, path, result)
        return result

