
// stock price
// k: consecutive months -> observable if no two month have the same price -> cumulative observable sum
// for n months

// We can use HashSet (non repeat) or HashMap
// Sliding window

class Solution {
    public int maxCumulativeObservableSum(int[] stockPrices, int k) {
        // remember to check edge case
        if (stockPrices.length < k) {
            return -1;
        }

        int maxSum = -1;
        int currentSum = 0; // sum of current window
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < stockPrices.length) {
            // !!! understand !!!
            if (i >= k) {
                currentSum -= stockPrices[i - k];
                set.clear();
                currentSum = 0;
                continue;
            }

            set.add(stockPrices[i]);
            currentSum += stockPrices[i];
            // 當窗口內的數量達到 k 並且所有數值都不相同時，更新最大值
            if (window.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}