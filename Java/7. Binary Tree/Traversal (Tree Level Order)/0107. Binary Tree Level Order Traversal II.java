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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 使用 LinkedList 可以從頭部插入，答案就不需再 reverse
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if (root != null) que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                temp.add(node.val);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            ans.addFirst(temp);
        }
        return ans;
    }
}