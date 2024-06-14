// Array
// 固定大小 / 相同 data type / 連續內存空間 / 2-dimension array


// left closed, right open interval

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
}




// 240529 2nd: syntax and return still needed to be concerned
class Solution {
    public int search (int[] nums, int target) {
        left = 0;
        right = nums.length - 1
        while (left < right) {
            mid = left + (right - left) / 2  // 防止 int overflow (if left = max - 2; right = max)
            if (nums[mid] < target) // if syntax
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] == target)
                return target
        } // where to place return statement
            return -1;
        }


// using recursion































