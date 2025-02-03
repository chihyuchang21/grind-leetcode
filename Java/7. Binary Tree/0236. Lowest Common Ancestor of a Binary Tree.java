/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        // post-order traversal
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {// 若未找到節點 p 或 q{
            return null;
        } else if (left == null && right != null) { // 若找到一個節點
            return right;
        }  else if (right == null & left != null) {
            return left;
        } else { // 若找到兩個節點
            return root;
        }
    }
}

// BFS
import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parentMap.put(root, null);
        queue.add(root);

        // Step 1: Store all parent-child relationships in a HashMap
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }

        // Step 2: Store all ancestors of p in a HashSet
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }

        // Step 3: Find the first ancestor of q that exists in p's ancestor set
        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }

        return q;
    }
}
