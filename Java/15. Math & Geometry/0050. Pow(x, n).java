// class Solution {
//     public double myPow(double x, int n) {
//         return Math.pow(x,n);
//     }
// }

// Asked in Amazon, Meta, Google, Linkedin, Bloomberg
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        else if (n < 0) {
            // even number
            if (n % 2 == 0) {
                n = n / 2;  // think
                n = - n;
                x = (1 / x) * (1 / x);
            } else { // odds don't need to be divided
                n = - n;
                x = 1 / x;
            }
        }
        if (n % 2 == 0) { // even
            return myPow(x * x, n / 2);
        } else { // odd
            return x * myPow(x * x, n / 2);
        }
    }
}
