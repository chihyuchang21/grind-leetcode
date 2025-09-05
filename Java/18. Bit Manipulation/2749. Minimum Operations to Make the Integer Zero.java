class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        if (num1 == 0) return 0;

        // hint 3: Notice that, if it is possible to make num1 equal to 0, then we need at most 60 operations.
        for (int k = 1; k <= 60; k++) {
            long S = (long) num1 - (long) k * (long) num2;
            if (S < 0) continue;

            int pc = Long.bitCount(S);
            if (pc <= k && k <= S) {
                return k;
            }
        }
        return -1;
    }
}
