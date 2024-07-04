/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<>(); // 儲存目前這一層的值
            int len = que.size(); // 紀錄這一層的數量

            while (len > 0) {
                Node tmpNode = que.poll();
                itemList.add(tmpNode.val);

                for (Node child : tmpNode.children) { // ??
                    que.offer(child);
                }
                len --;
            }
            result.add(itemList);
        }
        return result;
    }
}