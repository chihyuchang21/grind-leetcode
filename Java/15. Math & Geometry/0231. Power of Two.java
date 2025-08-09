// 2^1 = 2
// 2^2 = 4
// 2^3 = 8
// 2^4= 16
// 2^5 = 32

// 12 = 2 x 2 x 3
// 20 = 2 x 2 x 5
//    = 2 x 2 x 6
//    = 2 x 2 x 7

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
}