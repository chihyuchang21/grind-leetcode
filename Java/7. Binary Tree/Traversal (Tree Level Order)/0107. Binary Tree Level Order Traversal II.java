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

//class Solution {
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        // 使用 LinkedList 可以從頭部插入，答案就不需再 reverse
//        LinkedList<List<Integer>> ans = new LinkedList<>();
//        Queue<TreeNode> que = new LinkedList<>();
//
//        if (root != null) que.offer(root);
//
//        while (!que.isEmpty()) {
//            int size = que.size();
//            List<Integer> temp = new ArrayList<>();
//
//            for (int i = 0; i < size; i++) {
//                TreeNode node = que.poll();
//                temp.add(node.val);
//                if (node.left != null) que.offer(node.left);
//                if (node.right != null) que.offer(node.right);
//            }
//            ans.addFirst(temp);
//        }
//        return ans;
//    }
//}
//

public class Solution {

    /**
     * 解法：Queue，迭代。
     * 層序遍歷，再翻轉列表即可。
     */
    public List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();  // 使用 Queue 替代 Deque

        if (root == null) {
            return list;
        }

        que.offer(root);  // 直接使用 Queue 的 offer 方法加入節點
        while (!que.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();

            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode peek = que.poll();  // 使用 poll 方法從 Queue 的頭部取出節點
                levelList.add(peek.val);

                if (peek.left != null) {
                    que.offer(peek.left);
                }
                if (peek.right != null) {
                    que.offer(peek.right);
                }
            }
            list.add(levelList);
        }

        // 翻轉層序遍歷結果
        List<List<Integer>> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }

        return result;
    }
}
