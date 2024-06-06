// Sol 1: Recursion, O(N^2) -> 呼叫兩次
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}

// Sol 2: Dynamic Programming, O(N)
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int [] dp = new int[n + 1]; // 大小為 n + 1 的 array 來儲存值
        dp[0] = 0;
        dp[1] = 1;

        // 從 2 開始計算
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}