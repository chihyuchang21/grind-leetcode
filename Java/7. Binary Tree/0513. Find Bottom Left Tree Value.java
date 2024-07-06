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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int result = root.val;

        while (!que.isEmpty()) {
            int size = que.size();
            boolean isFirstNode = true;

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();

                if (isFirstNode) {
                    result = node.val;
                    isFirstNode = false;
                }

                if (node.left != null) {
                    que.offer(node.left);
                }

                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        return result;
    }
}