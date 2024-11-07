/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// 二元搜尋樹(BST)特性：
// 對於每個節點來說，左子樹的所有節點值都小於該節點值，右子樹的所有節點值都大於該節點值。
// 解題思路：
// 我們可以從根節點開始，利用 BST 的特性來判斷 ppp 和 qqq 的相對位置。
// 1. 如果 p 和 q 的值都小於當前節點的值，那麼它們都位於左子樹，繼續搜尋左子樹。
// 2. 如果 p 和 q 的值都大於當前節點的值，那麼它們都位於右子樹，繼續搜尋右子樹。
// 3. 如果 p 和 q 分別位於當前節點的兩邊，那麼當前節點就是它們的最近公共祖先。

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
