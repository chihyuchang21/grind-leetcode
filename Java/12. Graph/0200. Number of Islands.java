// DFS

class Solution {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (
                i < 0 ||
                        j < 0 ||
                        i >= grid.length ||
                        j >= grid[0].length ||
                        grid[i][j] == '0'
        ) {
            return;
        }
        grid[i][j] = '0'; // 標記為已訪問
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}

// BFS
class Solution {
    public int countIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 上、下、左、右

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    bfs(grid, i, j, directions);
                }
            }
        }
        return count;
    }

    private void bfs(int[][] grid, int i, int j, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = 0; // mark as visited

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isValid(grid, newRow, newCol)) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0; // mark as visited
                }
            }
        }
    }