public class Solution {

    public int maxProfitAfterStrategyChange(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        // 計算初始的利潤
        int initialProfit = calculateProfit(prices, strategy);

        int maxProfit = initialProfit;

        // 遍歷每個連續 k 天的策略修改
        for (int i = 0; i <= n - k; i++) {
            // 保存修改前的策略部分
            int[] originalPart = new int[k];
            for (int j = 0; j < k; j++) {
                originalPart[j] = strategy[i + j];
            }

            // 修改策略，前半段改為持有，後半段改為賣出
            for (int j = 0; j < k / 2; j++) {
                strategy[i + j] = 0;  // 持有
            }
            for (int j = k / 2; j < k; j++) {
                strategy[i + j] = 1;  // 賣出
            }

            // 計算修改策略後的利潤
            int newProfit = calculateProfit(prices, strategy);
            maxProfit = Math.max(maxProfit, newProfit);

            // 恢復策略
            for (int j = 0; j < k; j++) {
                strategy[i + j] = originalPart[j];
            }
        }

        return maxProfit;
    }

    // 計算當前策略下的總利潤
    private int calculateProfit(int[] prices, int[] strategy) {
        int profit = 0;
        int holdingPrice = -1;  // -1 代表我們沒有持有股票

        for (int i = 0; i < prices.length; i++) {
            if (strategy[i] == -1) {
                // 如果策略是買入
                holdingPrice = prices[i];
            } else if (strategy[i] == 1 && holdingPrice != -1) {
                // 如果策略是賣出，並且我們有股票持有
                profit += prices[i] - holdingPrice;
                holdingPrice = -1; // 賣出後沒有持有股票
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] strategy = {-1, 0, 1, -1, 0, 1, -1, 1}; // 示例策略
        int k = 4;

        int maxProfit = solution.maxProfitAfterStrategyChange(prices, strategy, k);
        System.out.println("最大利潤為: " + maxProfit);
    }
}
