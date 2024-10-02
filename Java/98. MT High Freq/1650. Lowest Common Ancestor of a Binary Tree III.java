/*
// Definition for a Node.
class Node {
    public int val;
    public Node parent;
    public Node(int val) {
        this.val = val;
        this.parent = null;
    }
}
*/

public class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        // Create a set to store the ancestors of node p
        Set<Node> ancestors = new HashSet<>();

        // Traverse from p to the root and add all nodes to the set
        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }

        // Traverse from q to the root and find the first common ancestor
        while (q != null) {
            if (ancestors.contains(q)) {
                return q; // This is the LCA
            }
            q = q.parent;
        }

        return null; // If there is no common ancestor (edge case)
    }
}
