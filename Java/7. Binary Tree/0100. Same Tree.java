/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 兩棵樹都空 → 相同
        if (p == null && q == null) {
            return true;
        }

        // 一棵是空的，另一棵不是 → 不相同
        if (p == null || q == null) {
            return false;
        }

        // 值不同 → 不相同
        if (p.val != q.val) {
            return false; // 這邊是 return false，如果是反向想 return true 就會導致還沒檢查完就以為是 same tree
        }

        // 左子樹不同 → 不相同
        boolean leftSame = isSameTree(p.left, q.left);
        if (!leftSame) {
            return false;
        }

        // 右子樹不同 → 不相同
        boolean rightSame = isSameTree(p.right, q.right);
        if (!rightSame) {
            return false;
        }

        // 都相同才回傳 true
        return true;
    }
}

