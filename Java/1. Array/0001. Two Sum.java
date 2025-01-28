// Sol1: Brute Force

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null; // exactly one solution
    }
}



// 2nd August 24'
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
    }
}

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int deduction = target - nums[i];
            if (map.containsKey(deduction) && map.get(deduction) != i) {
                result[0] = map.get(deduction);
                result[1] = i;
            }
        }

        return result;

    }

/**
 * 240807
 *
 * # Understand
 * 1. Does only one answer exist?
 * 2. Can the nums array be empty?
 * 3. Is the array sorted
 *
 *
 * # Match
 * 1. Brute Force (Array)
 *      Tc: O(N^2)
 *      SC: O(1)
 * 2. HashMap
 *      TC: O(N)
 *      SC: O(N)
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * [Brute Force] - Great progress, keep it up!
 * 0. Should use an online whiteboard to draw the graph first to ensure the basic settings for the for loop are correct.
 * 1. The end condition of the for loop (i < nums.length)
 * 2. The difference between int[] (array) and ArrayList
 *      When using int[], we can initialize it as int[2] first, or we can use new int[]{i, j} directly (important)
 * 3. Where to place return null result
 *
 * [HashMap]
 * 1. How to create a new HashMap<Integer, Integer>
 * 2. map.containsKey -> return boolean
 * 3. map.put(key, value) -> decide what to place in ma
 */




























// Brute Force: Using 2 For Loop
class Solution {
    public int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Answer");
    }
}