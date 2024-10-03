/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        // post-order traversal
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {// 若未找到節點 p 或 q{
            return null;
        } else if (left == null && right != null) { // 若找到一個節點
            return right;
        }  else if (right == null & left != null) {
            return left;
        } else { // 若找到兩個節點
            return root;
        }
    }
}