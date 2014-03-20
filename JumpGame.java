/*
 *Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 *Each element in the array represents your maximum jump length at that position.
 *
 *Determine if you are able to reach the last index.
 *
 *For example:
 *A = [2,3,1,1,4], return true.
 *
 *A = [3,2,1,0,4], return false.
 */

public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length;
        if (len < 2) {
            return true;
        }
        int reachable = 0;
        int cur = 0;
        while (cur <= reachable) {
            if (reachable >= len-1) {
                return true;
            }
            reachable = Math.max(reachable, A[cur]+cur);
            cur++;
        }
        return false;
    }
}
