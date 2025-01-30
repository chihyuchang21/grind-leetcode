class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;  // 遇到邊界或水，返回 0
        }

        grid[r][c] = 0; // 記錄已訪問過的格子（標記為水）

        // 計算當前島嶼的面積 = 1（當前格子）+ 上下左右四個方向遞迴
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c)
                + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
}
