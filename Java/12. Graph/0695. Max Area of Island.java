class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Set<String> visit = new HashSet<>();

        int area = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                area = Math.max(area, dfs(grid, visit, r, c)); // think, beautiful.
            }
        }
        return area;
    }

    private int dfs(int[][] grid, Set<String> visit, int r, int c) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if(r < 0 || r == ROWS || c < 0 || c == COLS || grid[r][c] == 0 || visit.contains(r + "," + c)) {
            return 0;
        }
        visit.add(r + "," + c);
        return 1 + dfs(grid, visit, r + 1, c) + dfs(grid, visit, r - 1, c) + dfs(grid, visit, r, c + 1) + dfs(grid, visit, r, c - 1);
    }
}