public class Solution {
    HashMap<String, Integer> dp;

    public int findTargetSumWays(int[] nums, int S) {
        dp = new HashMap<>();
        return calculate(nums, 0, 0, S);
    }

    public int calculate(int[] nums, int i, int sum, int S) {
        String s = i + "," + sum;

        if (i == nums.length) {
            return (sum == S)? 1 : 0;
        }
        if(dp.containsKey(s)){
            return dp.get(s);
        }

        int res = calculate(nums, i + 1, sum + nums[i], S) + calculate(nums, i + 1, sum - nums[i], S);
        dp.put(s, res);
        return res;
    }
}
