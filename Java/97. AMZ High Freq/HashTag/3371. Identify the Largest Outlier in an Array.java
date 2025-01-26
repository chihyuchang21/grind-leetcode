class Solution {
    public int getLargestOutlier(int[] nums) {
        // [2,3,5,10] -> 2,3 special; 5 sum; 10 outlier -> 20
        // [-2,-1,-3,-6,4] -> -8
        // if we remove the outlier, the sum value will be two times of special number
        // if we can find the special number, we can use hashmap to find the sum of them
        // edge case: can the nums be null? can the array's elements be all 0?

        Hashmap<Integer, Integer> map = new HashMap<>();

        if (nums.length == 0 || nums == null) {
            return 0;
        }


    }
}