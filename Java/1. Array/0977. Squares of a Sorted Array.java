// Two-pointers
class Solution{
    public int[] sortedSquares(int[] nums){

        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;

        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                result[index--] = nums[left] * nums[left++];
            }else{
                result[index--] = nums[right] * nums[right--];
            }
        }
        return result;
    }
}

// 240808
// Brute Force
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

// Two-pointers
class Solution {
    public int[] sortedSquares(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare; // largest result in array
                left += 1;
            } else {
                result[index] = rightSquare;
                right -= 1;
            }

            index -= 1;
        }

        return result;
    }
}

// 240909 應從 Array 最右邊開始填充
class Solution {
    public int[] sortedSquares(int[] nums) {
        // 創建一個新的數組來儲存結果
        int[] result = new int[nums.length];

        // 初始化左右指標
        int left = 0;
        int right = nums.length - 1;

        // 從結果數組的最後一個位置開始填充（因為平方數越大，數值越大）
        for (int i = nums.length - 1; i >= 0; i--) {
            // 比較 nums 左邊和右邊的平方數，將較大的填入結果數組
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;  // 移動左指標
            } else {
                result[i] = nums[right] * nums[right];
                right--;  // 移動右指標
            }
        }

        return result;
    }
}

// Math.abs(nums[left]) == Math.abs(nums[right]) 的情況移動哪一邊都可以


/**
 * 240808
 *
 * # Understand
 * 1. Is it possible for the elements in the array to be 'null'?
 * 2. Can the input array contain negative numbers?
 * 3. If the question states that the array is sorted in non-decreasing order, can there be any duplicate elements in this array?
 *
 * # Match
 * 1. Brute Force
 *      TC: O(N + NlogN) -> sort: O(NlogN)
 *      SC: O(1)
 * 2. Two Pointers
 *      TC: O(N)
 *      SC: O(N)
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * 1. In a sorted array, whether it is sorted in non-decreasing or non-increasing order, duplicates are allowed.
 * 2. Arrays.sort(nums)
 * 3. No additional handling for the equal case is needed.
 */