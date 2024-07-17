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

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<>(); // 儲存目前這一層的值
            int len = que.size(); // 紀錄這一層的數量

            for (int i = 0; i < len; i++) { // 使用 for 迴圈遍歷這一層的所有節點
                Node tmpNode = que.poll();
                itemList.add(tmpNode.val);

                // 使用 i < tmpNode.children.size() 的方式遍歷 children 列表
                for (int j = 0; j < tmpNode.children.size(); j++) { // usage
                    que.offer(tmpNode.children.get(j)); // 取得第 j 個子節點並加入隊列
                }
            }
            result.add(itemList);
        }
        return result;
    }
}
