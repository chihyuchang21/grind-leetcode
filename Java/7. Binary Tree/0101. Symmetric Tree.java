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
    public boolean isSymmetric(TreeNode root) {
        // 空樹視為對稱
        if (root == null) {
            return true;
        }

        // 檢查左右子樹是否鏡像
        boolean result = compare(root.left, root.right);
        return result;
    }

    private boolean compare(TreeNode left, TreeNode right) {
        // 一邊空、一邊非空 → 不對稱
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        // 兩邊都空 → 對稱（這一層結束）
        if (left == null && right == null) {
            return true;
        }

        // 檢查這一層 root 值（這裡就是在檢查各自子樹的 root）
        if (left.val != right.val) {
            return false;
        }

        // 外側：left.left vs right.right
        boolean compareOutside = compare(left.left, right.right);
        if (!compareOutside) {
            return false;
        }

        // 內側：left.right vs right.left
        boolean compareInside = compare(left.right, right.left);
        if (!compareInside) {
            return false;
        }

        // 兩邊都通過才算對稱
        return true;
    }
}
