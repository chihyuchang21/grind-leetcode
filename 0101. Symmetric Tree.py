# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#要比較的是left, right subtree是不是可互相翻轉的

class Solution(object):
    def isSymmetric(self, root):
        if not root:
            return True
        return self.compare(root.left, root.right)

    def compare(self, left, right):

        #先排除空節點的情況
        if left == None and right != None: return False
        elif left != None and right == None: return False
        elif left == None and right == None: return True

        #排除空節點後，再排除數值不相同的情況
        elif left.val != right.val: return False

        #剩下: 左右節點不為空、且數值相同的情況
        #此時才做recursion，做下一層的判斷
        outside = self.compare(left.left, right.right) #left subtree:left ; right subtree:right
        inside = self.compare(left.right, right.left)
        isSame = outside and inside #left, right subtree = medium (logic)
        return isSame