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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int len = que.size();
            int max = Integer.MIN_VALUE; // 初始化目前這層的最大值

            while (len > 0) {
                TreeNode node = que.poll();
                max = Math.max(max, node.val); // 更新目前這層的最大值

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                len --;
            }

            result.add(max);
        }
    return result;
    }
}