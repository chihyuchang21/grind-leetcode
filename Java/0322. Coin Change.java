class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int [] dp = new int[amount + 1];

        // 初始化 dp array 為最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }

        // amount = 0 時需要 0 個 coins
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 不是初始最大值時，該位才有選擇的必要
                if (dp[j - coins[i]] != max) {
                    // 選擇硬幣數最小的情況
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] < max) {
            return dp[amount];
        } else {
            return -1;
        }
    }
}