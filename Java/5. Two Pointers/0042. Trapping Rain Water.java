// Brute Force --> Time Limit Exceeded
class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            // find max length in the left side
            int leftMax = 0;

            for (int j = 0; j < i; j++) { // think
                leftMax = Math.max(leftMax, height[j]);
            }

            // find max length in the right side
            int rightMax = 0;

            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);

            }

            // calculate the water storage of current pillar
            int curWater = Math.min(leftMax, rightMax) - height[i];

            if (curWater > 0) {
                totalWater += curWater;
            }
        }

        return totalWater;
    }
}


// Two Pointers (left, right)
class Solution {
    public int trap(int[] height) {
        // Initialize two pointers
        int left = 0;
        int right = height.length - 1;

        // Track the maximum heights on both sides
        int leftMax = 0;
        int rightMax = 0;

        // Result variable to store the total amount of trapped water
        int totalWater = 0;

        // Start iterating
        while (left < right) {
            if (height[left] < height[right]) {
                // If the height on the left is less than the right
                if (height[left] >= leftMax) {
                    // Update the maximum height on the left side
                    leftMax = height[left];
                } else {
                    // If the current height is less than the left max height, calculate the trapped water
                    totalWater += leftMax - height[left];
                }
                // Move the left pointer
                left++;
            } else {
                // If the height on the right is less than or equal to the left
                if (height[right] >= rightMax) {
                    // Update the maximum height on the right side
                    rightMax = height[right];
                } else {
                    // If the current height is less than the right max height, calculate the trapped water
                    totalWater += rightMax - height[right];
                }
                // Move the right pointer
                right--;
            }
        }

        return totalWater;
    }
}



/**
 * 240809
 *
 * # Understand
 * 1. Does only one answer exist?
 *
 *
 *
 * # Match
 * 1. Brute Force (Array)
 *      Tc: O(N^2)
 *      SC: O(1)
 * 2. Two Pts
 *      TC: O(N)
 *      SC: O(1)
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * [Brute Force]
 * The core idea of the brute force approach is to calculate the amount of water that each pillar
 * can store. Specifically, for each pillar, you determine the maximum height on both its left and
 * right sides, take the minimum of these two heights, and then subtract the height of the current
 * pillar to get the amount of water it can store.
 * 暴力解法的核心思路是針對每個柱子，計算它能存儲的水量。對於每個柱子，計算其左右兩邊的最大高度，並且取這兩個高度的最小值，
 * 然後減去當前柱子的高度，得到該柱子能存儲的水量。
 *
 * 1. j for loop -> j < i
 * 2. curWater & totalWater
 *
 * [2 pts]
 *
 */