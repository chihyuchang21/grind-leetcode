public class Solution {
    public int uniquePaths(int m, int n) {
        // 如果網格的行或列為 0，則沒有路徑
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // 初始化第一行和第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 填充 dp 陣列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}