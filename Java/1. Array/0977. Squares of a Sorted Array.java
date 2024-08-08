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