/*
 *Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *For example, 
 *Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if (len < 2) {
            return 0;
        }

        int maxL[] = new int[len];
        int max = A[0];
        for (int i = 0 ; i < len ; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            maxL[i] = max;
        }
        int maxR[] = new int[len];
        max = A[len-1];
        int result = 0;
        for (int i = len-1 ; i >= 0 ; i--) {
            if (A[i] > max) {
                max = A[i];
            }
            maxR[i] = max;
            result += Math.min(maxR[i], maxL[i]) - A[i];
        }
        return result;
    }
}
