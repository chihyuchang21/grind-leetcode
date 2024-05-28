// 沒發生 swapped 代表數列已經 sorted

class Solution {
    public int missingNumber(int[] nums) {
        bubbleSort(nums);
        for (int k = 0; k < nums.length; k++) {
            // construct for loop to find missing number
            if (nums[k] != k) {
                return k;
            }
        }
        return nums.length;
    }

    private void bubbleSort(int[] nums) {
        boolean swapped;
        for (int i = 0; i < nums.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}