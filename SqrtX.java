/*
 *Implement int sqrt(int x).
 *
 *Compute and return the square root of x.
 */

public class Solution {
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x / 2 + 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if ((x / mid) == mid) {
                return mid;
            }
            if ((x / mid) < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (left+right)/2;
    }
}
