class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        Set<Integer> pac = new HashSet<>();
        Set<Integer> atl = new HashSet<>();

        for (int i = 0; i < ROWS; i++) {
            dfs(i, 0, pac, heights[i][0], ROWS, COLS, heights);
            dfs(i, COLS - 1, atl, heights[i][COLS - 1], ROWS, COLS, heights);
        }

        for (int j = 0; j < COLS; j++) {
            dfs(0, j, pac, heights[0][j], ROWS, COLS, heights);
            dfs(ROWS - 1, j, atl, heights[ROWS - 1][j], ROWS, COLS, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int coord = i * COLS + j;
                if (pac.contains(coord) && atl.contains(coord)) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, Set<Integer> visit, int prevHeight, int ROWS, int COLS, int[][] heights) {
        int coord = r * COLS + c;
        if (r < 0 || c < 0 || r == ROWS || c == COLS || heights[r][c] < prevHeight || visit.contains(coord)) {
            return;
        }
        visit.add(coord);
        dfs(r + 1, c, visit, heights[r][c], ROWS, COLS, heights);
        dfs(r - 1, c, visit, heights[r][c], ROWS, COLS, heights);
        dfs(r, c + 1, visit, heights[r][c], ROWS, COLS, heights);
        dfs(r, c - 1, visit, heights[r][c], ROWS, COLS, heights);
    }
}