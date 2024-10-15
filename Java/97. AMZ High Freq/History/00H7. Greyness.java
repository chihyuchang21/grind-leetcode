public class MaxGreyness {

    public static int findMaxGreyness(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] rowBlack = new int[n];
        int[] rowWhite = new int[n];
        int[] colBlack = new int[m];
        int[] colWhite = new int[m];

        // 統計每行和每列的黑白像素數量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowBlack[i]++;
                    colBlack[j]++;
                } else {
                    rowWhite[i]++;
                    colWhite[j]++;
                }
            }
        }

        int maxGreyness = Integer.MIN_VALUE;

        // 計算每個單元格的灰度值並找到最大值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 每個單元格的灰度值公式
                int greyness = rowBlack[i] + colBlack[j] - rowWhite[i] - colWhite[j];

                // 減去雙重計算的單元格值
                if (grid[i][j] == 1) {
                    greyness -= 1;
                } else {
                    greyness += 1;
                }

                // 更新最大灰度值
                maxGreyness = Math.max(maxGreyness, greyness);
            }
        }

        return maxGreyness;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        int result = findMaxGreyness(grid);
        System.out.println("Maximum Greyness: " + result);
    }
}
