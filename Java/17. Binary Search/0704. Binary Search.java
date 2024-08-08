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
        right = nums.length - 1;
        while (left < right) {
            mid = left + (right - left) / 2  // 防止 int overflow (if left = max - 2; right = max)
            if (nums[mid] < target) // if syntax
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] == target)
                return mid
        } // where to place return statement
            return -1;
        }


// 240620 3th (int, ;, return position)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
            left = mid + 1;
            }

            else if (nums[mid] > target) {
            right = mid - 1;
            }

            else if (nums[mid] == target){
                return mid;
            }
        return - 1;
        }
    }
}

//240630: 4th, <=, return position still (can't find)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return - 1;
    }
}

/**
 * 240807
 *
 * # Understand
 * 1. Can the nums array be empty?
 * 2. Is the array sorted
 *
 *
 * # Match
 * Binary Search
 *      TC: O(log N)
 *      SC: O(1) -> because we only use a few variables to store pointers (left, right, mid) and the target value.
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * 1. What to do to middle if it doesn't divide evenly?
 * 2. Using left + right may lead to integer overflow.
 * 3. [important] while (left <= right)
 */


/** Notes:
 * Binary search is an efficient method for finding an element in a sorted list.
 * Instead of checking each element sequentially (which would take O(N) time),
 * binary search repeatedly divides the list in half to narrow down the search.
 * This approach reduces the time complexity to O(log N).
 *
 * Here is how binary search works:
 *
 * 1. Start with two pointers, one pointing to the start (low) of the list and
 *    one pointing to the end (high) of the list.
 * 2. Find the middle element (mid) of the list.
 * 3. Compare the target element with the middle element:
 *    a. If they are equal, the search is complete.
 *    b. If the target is less than the middle element, repeat the search in the
 *       left half of the list.
 *    c. If the target is greater than the middle element, repeat the search in
 *       the right half of the list.
 * 4. Repeat steps 2-3 until the element is found or the search space is empty.
 *
 * Binary search requires that the list be sorted beforehand.
 */































