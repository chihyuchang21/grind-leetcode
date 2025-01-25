class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0; // 計算操作次數

        while (true) {
            // 找到數組中非零的最小值
            int minValue = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num > 0) {
                    minValue = Math.min(minValue, num);
                }
            }

            // 如果最小值還是 MAX_VALUE，表示所有元素為零，退出循環
            if (minValue == Integer.MAX_VALUE) {
                break;
            }

            // 將數組中所有非零元素減去這個最小值
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i] -= minValue;
                }
            }

            // 增加操作次數
            count++;
        }

        return count;
    }
}


// find the smallest value in array
// for loop to substract the value
