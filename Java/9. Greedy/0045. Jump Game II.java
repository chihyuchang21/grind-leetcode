class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int maxReach = 0;
        int lastJumpPos = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == lastJumpPos) {
                jumps++;
                lastJumpPos = maxReach;  // 更新下一次跳躍的最遠範圍

                if (maxReach >= nums.length - 1) {  // 如果已經能到終點，結束
                    break;
                }
            }
        }
        return jumps;
    }
}