class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resultList = new ArrayList<>(); // 用來裝答案
        Deque<TreeNode> que = new LinkedList<>(); // 輔助用的 Deque

        if (root == null) return resultList;
        que.offerLast(root); // 在進入 while loop 前先把當前 root 加進 queue

        while (!que.isEmpty()) {
            int levelSize = que.size(); // 這層有幾個 elements
            double levelSum = 0.0; // 加總先 initialized

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst(); // 先噴出第一個
                levelSum += poll.val; // 加

                if (poll.left != null) que.addLast(poll.left);
                if (poll.right != null) que.addLast(poll.right);
            }
            resultList.add(levelSum / levelSize);
        }
        return resultList;
    }
}