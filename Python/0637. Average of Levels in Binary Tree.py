# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def averageOfLevels(self, root):
        if not root:
            return []

        queue = collections.deque([root])
        averages = []

        while queue:
            size = len(queue)
            level_sum = 0

            for i in range(size):
                node = queue.popleft()

                level_sum += node.val

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            averages.append (float(level_sum) / size)

        return averages