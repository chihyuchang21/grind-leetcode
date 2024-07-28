// Method 1
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


// Method 2 (NeetCode)
class Solution {

    public int coinChange(int[] coins, int amount) {
        // 基本檢查，如果amount小於0或coins數組為空，直接返回0
        if (amount < 0 || coins.length == 0 || coins == null) {
            return 0;
        }

        // 創建一個長度為amount + 1的數組來保存每個金額所需的最少硬幣數
        int[] dp = new int[amount + 1];
        // 將數組初始化為amount + 1，因為這是一個不可能的高值（比amount還大）
        Arrays.fill(dp, amount + 1);
        // 金額為0時，所需硬幣數量為0
        dp[0] = 0;

        // 遍歷每個金額
        for (int i = 1; i <= amount; i++) {
            // 對於每個金額，檢查每一個硬幣面值
            for (int coin : coins) {
                // 如果金額i大於等於硬幣面值，則更新dp[i]
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // 如果dp[amount]沒有被更新，則返回-1，否則返回dp[amount]
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
