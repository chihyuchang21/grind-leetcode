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

// 1. recursion (think!)
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
            return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

// 2. iteration
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int count = 0;

        while (!que.isEmpty()) {
            TreeNode currentNode = que.poll();
            count++;

            if (currentNode.left != null) {
                que.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                que.offer(currentNode.right);
            }
        }
        return count;
    }
}