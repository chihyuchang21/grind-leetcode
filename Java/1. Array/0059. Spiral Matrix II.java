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
/*
In LeetCode 59's solution, the condition while (loop < n / 2) controls the number of layers (or loops)
 that will be filled in the spiral matrix.

- Explanation:
Layers of the Spiral:
The variable loop represents the current layer of the matrix being filled in the spiral order.
Each iteration of the while loop fills one outer layer of the matrix, which consists of four sides
(top, right, bottom, left). After completing one layer (or one "loop"), loop is incremented,
and the next inner layer starts being filled.

- Why n / 2?:
When n is even: There are exactly n / 2 layers to fill.
For example, in a 4x4 matrix, there are two layers to fill: one outer layer and one inner layer.
When n is odd: The n / 2 ensures that only the outer layers are filled in the spiral,
leaving a single center element. The center element is then handled separately with the if (n % 2 == 1)
check after the loop. For example, in a 5x5 matrix, there are two layers to fill,
and the center element is filled after those layers.

- Summary:
The condition while (loop < n / 2) ensures that the spiral filling process continues
until all outer layers of the matrix are filled.
If the matrix has an odd size, the center element is filled at the end of the process.
 */