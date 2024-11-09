class Solution {
    public int search(int[] nums, int target) {
        // ascending order (= ordered)
        // not exist  return - 1
        // TC: O(log n)
        int left = 0;
        int right = nums.length - 1;

        // The if: 1 2 3 (4) 5 6 7 -> tar: 2
        // The elif: 1 2 3 (4) 5 6 7 -> tar: 5

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) { // tar in the left
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return - 1;
    }
}