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

// recursive
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, 0, result);
        return result;
    }

    private void rightView(TreeNode node, int depth, List<Integer> result) {
        // 基本條件：當節點為 null 時結束
        if (node == null) return;

        // 若當前深度與 result 大小相等，表示是第一次到達這個深度，加入該層的最右側節點
        if (depth == result.size()) {
            result.add(node.val);
        }

        // 優先遍歷右子樹，然後遍歷左子樹
        rightView(node.right, depth + 1, result);
        rightView(node.left, depth + 1, result);
    }
}




// Iteration
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) return list;
        que.offerLast(root);

        while (!que.isEmpty()) {
            int levelSize = que.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();

                if (poll.left != null) que.addLast(poll.left);
                if (poll.right != null) que.addLast(poll.right);
                if (i == levelSize - 1) list.add(poll.val);
            }
        }
        return list;
    }
}