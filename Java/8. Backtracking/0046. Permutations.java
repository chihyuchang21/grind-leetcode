class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 1) {
            List<Integer> singleNum = new ArrayList<>();
            singleNum.add(nums[0]);
            result.add(singleNum);
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int[] remainingNums = new int[nums.length - 1];
            int idx = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    remainingNums[idx++] = nums[j];
                }
            }
            List<List<Integer>> perms = permute(remainingNums);

            for (List<Integer> perm : perms) {
                perm.add(n);
                result.add(new ArrayList<>(perm));
            }
        }
        return result;
    }
}