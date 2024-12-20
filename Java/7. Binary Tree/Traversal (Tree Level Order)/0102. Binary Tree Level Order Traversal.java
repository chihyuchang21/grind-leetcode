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

// BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root != null) {
            que.add(root);
        }

        while (!que.isEmpty()) {
            List<Integer> levelValue = new ArrayList<>();
            int levelSize = que.size(); // 保存當前層的節點數量

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = que.poll();
                levelValue.add(node.val);

                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            result.add(levelValue);
        }
        return result;
    }
}

// recursive
 class Solution {

     public List<List<Integer>> resList = new ArrayList<List<Integer>>();

     public List<List<Integer>> levelOrder(TreeNode root) {
         buildTreeRecursive(root, 0, resList); // 傳入 resList 而不是 result
         return resList;
     }

     public void buildTreeRecursive(TreeNode node, Integer level, List<List<Integer>> result) {
         // Base Case
         if (node == null) {
             return;
         }

         if (level == result.size()) {
             result.add(new ArrayList<>());
         }

         List<Integer> levelList = result.get(level);
         levelList.add(node.val);

         buildTreeRecursive(node.left, level + 1, result);
         buildTreeRecursive(node.right, level + 1, result);
     }
 }


// 1-1 Deque by NeetCode
// Notice: add value to queue or levelValue (List<Int> in result List)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        if (root != null) {
            que.add(root); // 1st time: add first root node on 1st level
        }

        while (!que.isEmpty()) {
            List<Integer> levelValue = new ArrayList<>();
            int levelSize = que.size(); // 保存當前層的節點數量; 1st time: 1

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = que.poll();
                levelValue.add(node.val);

                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            result.add(levelValue);
        }
        return result;
    }
}