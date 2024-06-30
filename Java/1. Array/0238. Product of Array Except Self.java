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

// 2. Product of all and then divide the product (smart!) -> O(N) -> 有被除數可能為 0 的可能
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int pro = 1;

        for (int i : nums) {
            pro *= i;
        }

        for (int i = 0; i < n; i++) {
            ans[i] = pro / nums[i];
        }
        return ans;
    }
}

// 3. Suffix & Prefix Product
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // 初始化 ans 陣列的值為 1
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }

        int leftPro = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= leftPro;
            leftPro *= nums[i];
        }

        int rightPro = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightPro;
            rightPro *= nums[i];
        }

        return ans;
    }
}
