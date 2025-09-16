// 題目無規定要從第一間開始偷，你可以選擇偷或不偷第一間，DP 會自動考慮所有可能情況
// 因為 DP 的定義就是「考慮到第 i 間房子時的最佳解」：
// dp[0] = nums[0] → 只有一間房時，最佳就是偷它。
// dp[1] = max(nums[0], nums[1]) → 兩間房時，最佳可以是偷第一間，也可以是偷第二間。
// dp[i] = max(dp[i-1], dp[i-2] + nums[i]) → 這裡其實就是比較：
// 不偷第 i 間（等於 dp[i-1]）
// 偷第 i 間（等於 dp[i-2] + nums[i]）
// 這樣的遞推關係，自然就涵蓋了「偷第 1 間 or 不偷第 1 間」的情況，不需要我們手動去限制。

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
