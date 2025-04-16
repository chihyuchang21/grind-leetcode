// brute force
// misunderstood the meaning of q
// class Solution {
//     public long countGood(int[] nums, int k) {
//         int count = 0;
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] == nums[j]) {
//                     count += 1;
//                 }
//             }
//         }

//         if (count >= k) {
//             return count;
//         }
//     }
// }

// Brute Force (Not totally understand) // TLE
class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            long pairs = 0;

            for (int j = i; j < n; j++) {
                int count = freq.getOrDefault(nums[j], 0);

                // 每加入一個重複值就多出 count 個新對
                pairs += count;

                freq.put(nums[j], count + 1);

                if (pairs >= k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
