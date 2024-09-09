//Sliding Window
class Solution{
    public int minSubArrayLen(int s, int[] nums){

        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right ++){
            sum += nums[right];
            while (sum >= s){
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

// 默寫
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;          // 左指針初始化
        int sum = 0;           // 總和初始化
        int result = Integer.MAX_VALUE; // 最小子數組長度初始化為最大值

        for (int right = 0; right < nums.length; right++) {  // 右指針從 0 遍歷到 nums.length - 1
            sum += nums[right];   // 擴展窗口，增加右邊的數字

            // 當窗口內的和大於或等於目標值時
            while (sum >= s) {
                result = Math.min(result, right - left + 1); // 更新最小長度
                sum -= nums[left++];  // 縮小窗口，減少左邊的數字
            }
        }

        // 根據 result 是否為初始值來決定返回值
        if (result == Integer.MAX_VALUE) {
            return 0;  // 如果 result 沒有被更新，返回 0
        } else {
            return result;  // 否則返回最小長度
        }
    }
}

// 240909
// Sliding Window
class Solution{
    public int minSubArrayLen(int s, int[] nums){

        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        // Using one for loop (the endpoint of sliding window)
        for(int right = 0; right < nums.length; right ++){
            sum += nums[right];
            while (sum >= s){
                result = Math.min(result, right - left + 1);
                sum -= nums[left];  // 將左邊界的元素從總和中減去
                left++;             // 移動左邊界指標
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        } else {
            return result;
        }
    }
}

/**
 * 240809
 *
 * # Understand
 * 1. Can the array contain negative numbers?
 * 2. Can the array nums be empty?
 * 3. Does the subarray need to be contiguous?
 *
 *
 * # Match
 * 1. Brute Force
 *      Tc:
 *      SC:
 * 2. Sliding Window
 *      TC: O(N)
 *      -> Don't assume that placing a while loop inside a for loop automatically results in O(n²) complexity.
 *      The key is to consider how many times each element is operated on. In the sliding window approach,
 *      each element is processed once when it enters the window and once when it leaves.
 *      Since each element is operated on twice, the time complexity is 2 × n, which simplifies to O(n).
 *      SC: O(1)
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * [Brute Force]
 * [2 pts]
 *
 */