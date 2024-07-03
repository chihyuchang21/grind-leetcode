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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) return list;
        que.offerLast(root);

        while (!que.isEmpty()) {
            int levelSize = que.size();
            double levelSum = 0.0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();
                levelSum += poll.val;

                if (poll.left != null) que.addLast(poll.left);
                if (poll.right != null) que.addLast(poll.right);
            }
            list.add(levelSum / levelSize);
        }
        return list;
    }
}