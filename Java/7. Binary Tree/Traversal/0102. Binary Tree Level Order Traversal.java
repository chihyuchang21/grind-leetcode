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

// 1. recursive
class Solution {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        buildTreeRecursive(root, 0);
        return resList;
    }

    public void buildTreeRecursive(TreeNode node, Integer deep) {
        if (node == null) return;
        deep ++;

        if (resList.size() < deep) {
            // 層級增加、list 的 item 也會增加，利用 list 的 index 進行層級界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        buildTreeRecursive(node.left, deep);
        buildTreeRecursive(node.right, deep);
    }
}