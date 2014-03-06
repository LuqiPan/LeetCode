/*
 *Implement pow(x, n).
 */

public class Solution {
    public double pow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return power(x, n);
        } else {
            return 1 / power(x, -n);
        }
    }
    public double power(double x, int n) {
        if (n % 2 == 0) {
            double x2 = pow(x, n/2);
            return x2 * x2;
        } else {
            double x2 = pow(x, n/2);
            return x * x2 * x2;
        }
    }
}
