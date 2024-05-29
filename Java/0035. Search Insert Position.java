class Solution {
    public int searchInsert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;

        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                tail = mid - 1;
            else
                head = mid + 1;
        }
        return head;
    }
}