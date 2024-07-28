public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 定義 dp 陣列
        int[][] dp = new int[m][n];

        // 初始化 dp[0][0]
        dp[0][0] = grid[0][0];

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // 填充 dp 陣列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        // 返回右下角的值
        return dp[m-1][n-1];
    }
}
