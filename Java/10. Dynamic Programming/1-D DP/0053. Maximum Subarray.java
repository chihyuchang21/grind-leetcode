// Brute Force - TC:O(N^2) ; SC:O(1)
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int result = Integer.MIN_VALUE;
//         int n = nums.length;

//         for (int i = 0; i < n; i++) {
//             int curSum = 0; // 這邊是只要換起點就要歸零
//             for (int j = i; j < n; j++) {
//                 curSum += nums[j];

//                 if (curSum > result) {
//                     result = curSum;
//                 }
//             }
//         }
//         return result;
//     }
// }

// DP - TC:O(N) ; SC:O(N)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0]; // dp array 的意義是: 至此位(含)的 max subarray sum
        int result = dp[0];

        for (int i = 1; i < n; i++) {
            if (dp[i-1] > 0) { // 前面有幫助(>0)，則接上
                dp[i] = dp[i-1] + nums[i];
            } else { // 前一段拖累(<0)，重開
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

// TO-DO: Kadane’s Algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int cur = nums[0];      // 相當於 dp[i]
        int result = nums[0];   // 記錄歷史最大值

        for (int i = 1; i < nums.length; i++) {
            if (cur > 0) {
                cur = cur + nums[i];  // 接上
            } else {
                cur = nums[i];        // 重開
            }
            result = Math.max(result, cur);
        }

        return result;
    }
}
