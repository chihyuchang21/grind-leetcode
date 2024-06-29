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

/** Notes:
 * Brute-force: 2 for loop -> Time complexity: O(N*2)
 * Two-pointers (fast-slow) -> Time complexity: O(N) -> Use one for loop to do what two for loop can do
 * Thoughts: return slow pointer index, nums[slow] = nums[fast], != val -> fast will still ++
 */
