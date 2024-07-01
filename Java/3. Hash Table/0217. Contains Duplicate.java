// 240701 1st: 一開始的想法有成功 new 出一個 Map、用 getOrDefault 算頻率，但更正確的應該是用 Set (完全沒想到)
// !set.add(num) usage

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}