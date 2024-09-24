// class Solution {
//     public void moveZeroes(int[] nums) {
//         int j = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != 0) {
//             int temp = nums[j];
//             nums[j] = nums[i];
//             nums[i] = temp;
//             j++;
//             }
//         }
//     }
// }

class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        // For elements which are not zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // For elements which are zero
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}



/**
 * 240811
 *
 * # Understand
 * 1. Is the input array guaranteed to contain at least one zero?
 * 2. What should happen if all elements in the array are zeros?
 *
 *
 * # Match
 * 1. Brute Force
 *      Tc: N/A
 *      SC: N/A
 * 2. Temp Pointer Method
 *      TC:
 *      SC: O(1)
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * See notebook
 */