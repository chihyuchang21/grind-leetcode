class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;

        int[] dp = new int[n+1];
        dp [0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

// SC 可再 optimize to O(1)
class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}

// 1. n = 1， result = 1
// 2. n = 2, result = 1+1 (爬1階兩次 + 一次爬兩階)
// 3. n = 3, result = 1+2 (前面兩個case相加)
// 4. n = 4, result = 3+2 (前面兩個case相加)
// 5. 發現其實這題就是算費氏數列
