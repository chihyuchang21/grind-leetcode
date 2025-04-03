// class Solution {
//     public long maximumTripletValue(int[] nums) {
//         long maxSum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 for (int k = j + 1; k < nums.length; k++) {
//                     long curSum = (long)(nums[i] - nums[j]) * nums[k]; // 用 int 會 overflow
//                     maxSum = Math.max(maxSum, curSum);
//                 }
//             }
//         }
//         return maxSum;

//     }
// }

// 固定中間的 j
// 對於每個 j：
// 左邊找：max_i = max(nums[0] ~ nums[j - 1])
// 右邊找：max_k = max(nums[j + 1] ~ nums[n - 1])

// 因為如果你固定了 j，你只需要找在 i < j 的所有 i 裡面誰的 nums[i] 最大，
// 才能讓 (nums[i] - nums[j]) 最大；同樣，nums[k] 越大，乘出來的值就越大。

// 這是一種貪心思想：「我不需要試所有 i 和 k，只要試最大值就好」，
// 為越大才越有可能讓乘積變最大。

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max = 0;

        for (int j = 1; j < n - 1; j++) {
            int max_i = 0;
            for (int i = 0; i < j; i++) {
                max_i = Math.max(max_i, nums[i]);
            }

            int max_k = 0;
            for (int k = j + 1; k < n; k++) {
                max_k = Math.max(max_k, nums[k]);
            }

            long value = (long)(max_i - nums[j]) * max_k;
            max = Math.max(max, value);
        }

        return max;
    }
}

