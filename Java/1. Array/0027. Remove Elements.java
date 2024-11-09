// 2 pts: fast & slow pt
// fast pt: find new array element
// slow pt: updated new array's index

class Solution {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
         if (nums[fastIndex] != val) {
             nums[slowIndex] = nums[fastIndex];
             slowIndex++;
         }
        }
        return slowIndex;
    }

    // 240627 2nd
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) { // 邊界
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex]; // think!
                slowIndex++;
            }
        }
        return slowIndex;
    }
}

// 240808
class Solution {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] == val) {
                // Do nothing
            } else {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}

// 240905


/**
 * 240808
 *
 * # Understand
 * 1. Should we return the array, or do we only need to return the length of the array nums?
 * 2. Is the input array guaranteed to be non-empty?
 *
 * # Match
 * 1. Brute Force
 *      TC: O(N^2)
 *      SC: O(1)
 * 2. Two Pointers
 *      TC: O(N)
 *      SC: O(1)
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * 1. My logic is reversed; I got stuck when nums[fastIndex] == val. -> better solution for me!
 * 2. Don't understand the meaning of returning 'slowIndex'
 * 3. 241109: 這題tricky的地方在於只要回傳刪掉後的length，所以只要注意slowIndex的Index value就好
 * slowIndex 用來標記下一個放置"非 val 值"的位置
 */




