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
    public List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.left);
        result.add(root.val);
        traversal(root.right);
    }
}