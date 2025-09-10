// Brute Force [TC:O(N^2)]

// nums = [1,1,1]
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) { // 固定 i 為左邊界
            int curSum = 0; // 若左邊界換則 curSum 需歸零
            for (int j = i; j < n; j++) {
                curSum += nums[j];
                if (curSum == k) {
                    count += 1;
                }
            }
        }
        return count;
    }
}



class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}