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

// 01. recursion DFS
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}


// 02. iteration BFS
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++; // 每進入一層，深度加一

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll(); // 取出佇列中的節點

                if (current.left != null) {
                    queue.offer(current.left);  // 如果有左子節點，加入佇列
                }
                if (current.right != null) {
                    queue.offer(current.right); // 如果有右子節點，加入佇列
                }
            }
        }

        return depth;
    }
}
