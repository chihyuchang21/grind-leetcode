// 寬為兩者 index 的間距、高為 min 者的高度
// First Time - Wrong Answer: 不該只移動 left，而是依高度來移動 pointer
// I need two hints: Math.min ; pointer move

class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int target = 0; // default value = 0

        while (left < right) {
            // 高度
            int heightCalculated = Math.min(height[left], height[right]);
            // 長度
            int length = right - left;

            int targetCurrent = heightCalculated * length;

            if (targetCurrent > target) {
                target = targetCurrent;
            }

            if (height[left] < height[right]) {
                left ++;
            }
            else {
                right --;
            }
        }
        return target;
    }
}