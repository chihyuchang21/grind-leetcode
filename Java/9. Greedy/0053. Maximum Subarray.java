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
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}

// TO-DO: Kadane’s Algorithm
// https://chatgpt.com/share/68c489b7-61b8-800b-8947-9c995eb049a9