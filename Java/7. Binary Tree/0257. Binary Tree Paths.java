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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            String currentPath = pathQueue.poll();

            // 如果是葉子節點，將當前路徑加入結果列表
            if (currentNode.left == null && currentNode.right == null) {
                paths.add(currentPath);
            } else {
                if (currentNode.left != null) {
                    nodeQueue.offer(currentNode.left);
                    pathQueue.offer(currentPath + "->" + currentNode.left.val);
                }
                if (currentNode.right != null) {
                    nodeQueue.offer(currentNode.right);
                    pathQueue.offer(currentPath + "->" + currentNode.right.val);
                }
            }
        }

        return paths;
    }
}
