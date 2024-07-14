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
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        buildTreeRecursive(root, 0); // 法 1
        buildTreeQueue(root); // 法 2
        return resList;
    }

    // 1. Recursive
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

    // 2. Using Queue Size
    public void buildTreeQueue(TreeNode node) {
        if (node == null) return;
        Queue <TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);    // offer 在 queue 滿時不會拋錯，跟 add 不同

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>(); // 儲存這層的值
            int len = que.size(); // 這層的節點數量

            while (len > 0) {
                TreeNode tmpNode = que.poll(); // 從 queue 中取出一個節點
                itemList.add(tmpNode.val);

                if(tmpNode.left != null) que.offer(tmpNode.left); // 若有左節點則加入
                if(tmpNode.right != null) que.offer(tmpNode.right); // 若有右節點則加入
                len --; // 遍歷
            }
        }
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

            for (int i = 0; i levelSize; i++) {
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