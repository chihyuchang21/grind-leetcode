// 股票買賣只能往前走
// 若左方價格都較高則 return 0 (no profit)

class Solution {
    // Two Pointer
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {

            // 買價越低越好，比較低的話就拿走
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }
            else {
                profit = Math.max(profit, prices[i] - buyPrice);
            }
        }
        return profit;
    }
}