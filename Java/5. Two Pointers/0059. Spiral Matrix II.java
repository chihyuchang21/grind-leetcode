class Solution {
    public int[][] generateMatrix(int n) {
        int loop = 0;   // Number of loops
        int[][] res = new int[n][n];
        int start = 0;  // Starting point of each loop (start, start)
        int count = 1;  // Number to fill
        int i, j;

        while (loop < n / 2) { // Loop starts at 0, stops when reaching boundary
            // Simulate filling the top side from left to right
            for (j = start; j < n - loop - 1; j++) {
                res[start][j] = count++;
            }

            // Simulate filling the right side from top to bottom
            for (i = start; i < n - loop - 1; i++) {
                res[i][j] = count++;
            }

            // Simulate filling the bottom side from right to left
            for (; j > loop; j--) {
                res[i][j] = count++;
            }

            // Simulate filling the left side from bottom to top
            for (; i > loop; i--) {
                res[i][j] = count++;
            }

            // Move to the next inner loop
            start++;
            loop++;
        }

        // Handle the center element for odd n
        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}


/**
 * 240809
 *
 * # Understand
 *
 *
 *
 *
 * # Match
 * 1. Brute Force Array)
 *      Tc:
 *      SC:
 * 2. Two Pts
 *      TC: N)
 *      SC:
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * 二刷還是沒有很懂...
 *
 *
 */