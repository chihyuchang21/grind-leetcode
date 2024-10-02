/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    // 遞歸函數，計算加權和
    private int helper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                // 如果是整數，乘以當前深度並加入和
                sum += ni.getInteger() * depth;
            } else {
                // 如果是列表，遞歸處理
                sum += helper(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}


// DFS
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // 使用 DFS 來處理加權和
        return dfs(nestedList, 1);
    }

    // DFS 輔助方法，遍歷嵌套列表
    private int dfs(List<NestedInteger> nestedList, int depth) {
        int sum = 0;  // 儲存加權和

        // 遍歷列表中的每個元素
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                // 如果是整數，計算權重並加到總和中
                sum += ni.getInteger() * depth;
            } else {
                // 如果是列表，進一步深入該列表，遞增深度
                sum += dfs(ni.getList(), depth + 1);
            }
        }

        // 返回當前深度的總和
        return sum;
    }
}
