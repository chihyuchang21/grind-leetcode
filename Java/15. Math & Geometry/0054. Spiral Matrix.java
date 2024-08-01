class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int loop = 0; // 循環次數
        int start = 0; // 每次循環的開始點(start, start)
        int i, j;

        while (loop++ < Math.min(rows, cols) / 2) { // 判斷邊界後，loop從1開始
            // 模擬上端從左到右
            for (j = start; j < cols - loop; j++) {
                res.add(matrix[start][j]);
            }

            // 模擬右側從上到下
            for (i = start; i < rows - loop; i++) {
                res.add(matrix[i][j]);
            }

            // 模擬下側從右到左
            for (; j >= loop; j--) {
                res.add(matrix[i][j]);
            }

            // 模擬左側從下到上
            for (; i >= loop; i--) {
                res.add(matrix[i][j]);
            }

            start++;
        }

        // 如果矩陣的行數或列數是奇數，處理中心點
        if (Math.min(rows, cols) % 2 == 1) {
            if (rows <= cols) {
                for (j = start; j < cols - loop + 1; j++) {
                    res.add(matrix[start][j]);
                }
            } else {
                for (i = start; i < rows - loop + 1; i++) {
                    res.add(matrix[i][start]);
                }
            }
        }

        return res;
    }
}
