// https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview/
// 1. Brute Force (Time Limit Exceeded) -> O(N^2)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int pro = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }
        return ans;
    }
}

// 2. Product of all and then divide the product (smart!) -> O(N) -> 有被除數可能為 0 的可能 (/ by zero)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];

        int product = 1;

        for (int i = 0; i < n; i++) {
            product *= nums[i];
        }

        for (int j = 0; j < n; j++) {
            result[j] = product / nums[j];
        }

        return result;
    }
}


// 3. Suffix & Prefix Product
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = 1;
        }

        // left product
        int leftPro = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = answer[i] * leftPro; // memorize this! // 確保第一個值不會乘到其他東西
            leftPro = leftPro * nums[i];
        }

        int rightPro = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightPro;
            rightPro = rightPro * nums[i];
        }
        return answer;
    }
}

//         index: 0 1 2 3
// Input: nums = [1,2,3,4]
// Output: ans = [24,12,8,6]
//               [1,1,1,1]

// leftPro / ans = [1,1,2,6]
// rightPro / ans = [] -> same, but reversed

/**
 * 240810
 *
 * # Understand
 * 1. Does only one answer exist?
 *
 *
 *
 * # Match
 * 1. Brute Force (TLE)
 *      Tc: O(N^2)
 *      SC: O(1)
 * 2. Two Pts
 *      TC: O(N)
 *      SC: O(1)
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * [Brute Force]
 * 1. Initialize product to 1 and continuously multiply
 * 2. How to exclude itself? -> if statement (i != j)
 * 3. Fist for loop -> iterate array 'result'; Second for loop -> iterate elements in array 'nums'
 *
 * [Division] unsolved issue
 *
 * [Prefix & Suffix]
 * 0. Initialize the result array as an array filled with 0s.
 * 1. The prefix product array stores the product of all elements before each position.
 * 2. The suffix product array stores the product of all elements after each position.
 */