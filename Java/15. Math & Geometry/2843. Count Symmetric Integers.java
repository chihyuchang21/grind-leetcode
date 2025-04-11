// 250411 Daily
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            // Didn't think of String.valueOf
            String numStr = String.valueOf(i);
            int len = numStr.length();

            // First I think of using while
            if (len % 2 == 0) {
                int half = len / 2;
                int leftSum = 0;
                int rightSum = 0;

                for (int j = 0; j < half; j++) {
                    leftSum += numStr.charAt(j) - '0';
                }
                for (int j = half; j < len; j++) {
                    rightSum += numStr.charAt(j) - '0';
                }

                if (leftSum == rightSum) {
                    count++;
                }
            }
        }
        return count;
    }
}

// TC: O(N)
// SC: O(1) -> (O(6))