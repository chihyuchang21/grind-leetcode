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

// 一般遞迴: binary tree
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        if (left != null) {
            return left;
        }
        return searchBST(root.right, val);
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        // 如果目標值小於當前節點的值，則往左子樹搜尋
        if (val < root.val) {
            return searchBST(root.left, val);
        } else { // 否則往右子樹搜尋
            return searchBST(root.right, val);
        }
    }
}