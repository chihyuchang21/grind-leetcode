class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] greedy = new boolean[3]; // think

        for (int[] triplet : triplets) {
            boolean isValid = true;

            // 檢查當前的 triplet 是否有效
            for (int i = 0; i < 3; i++) {
                if (triplet[i] > target[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                // 更新 greedy 狀態
                for (int i = 0; i < 3; i++) {
                    if (triplet[i] == target[i]) {
                        greedy[i] = true;
                    }
                }
            }
        }

        return greedy[0] && greedy[1] && greedy[2];
    }
}
