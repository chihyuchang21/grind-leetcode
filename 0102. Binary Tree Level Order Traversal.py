# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#法一: 長度法
class Solution(object):
    def levelOrder(self, root):
        if not root:
            return []

        queue = collections.deque([root])
        result = []

        while queue:
            level = []
            for _ in range(len(queue)):
                cur = queue.popleft()
                level.append(cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            result.append(level)
        return result


#法二: recursion
class Solution(object):
    def levelOrder(self, root):
        levels = []
        self.helper(root, 0, levels)
        return levels

    def helper(self, node, level, levels):
        if not node:
            return
        if len(levels) == level:
            levels.append([])
        levels[level].append(node.val)

        self.helper(node.left, level + 1, levels)
        self.helper(node.right, level + 1, levels)