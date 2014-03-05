/*
 *You are climbing a stair case. It takes n steps to reach to the top.
 *
 *Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] T = new int[n+1];
        T[0] = 0;
        T[1] = 1;
        T[2] = 2;
        for (int i = 3 ; i <= n ; i++) {
            T[i] = T[i-1] + T[i-2];
        }
        return T[n];
    }
}
