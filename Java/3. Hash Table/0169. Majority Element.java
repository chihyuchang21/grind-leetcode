class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return 0;
    }
}

/**
 * 2408
 *
 * # Understand
 * 1. Are there any requirement on time complexity?
 * 2. If the element appears exactly n / 2 times, does it count?
 *
 *
 *
 * # Match
 * 1. Brute Force
 *      Tc:
 *      SC:
 * 2. HashMap
 *      TC: O(N)
 *      SC: O(N)
 *
 * # Plan
 *  1. Using a for loop to iterate through the elements in the array nums and add (nums[i], freq) as a key-value pair in the HashMap.
 *  2. Using an if statement to ensure that the key with the highest frequency occurs more than n / 2 times.
 *
 * # Implement
 * # Review
 * # Evaluate
 *
 * # Notes
 * 1. How to initialize a new hashmap
 * 2. map.getOrDefault -> can be used to solve frequency problem
 *
 */