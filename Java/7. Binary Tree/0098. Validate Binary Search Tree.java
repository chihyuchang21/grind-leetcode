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
    private long prev = Long.MIN_VALUE; // 初始設定 prev 為最小值，方便比較

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true; // 到達空節點，視為合法

        // 遞迴檢查左子樹，若不合法則直接返回 false
        if (!isValidBST(root.left)) return false;

        // 比較當前節點的值是否大於前一個節點的值
        if (root.val <= prev) return false;

        // 更新 prev 為當前節點的值
        prev = root.val;

        // 遞迴檢查右子樹，若不合法則直接返回 false
        return isValidBST(root.right);
    }
}
