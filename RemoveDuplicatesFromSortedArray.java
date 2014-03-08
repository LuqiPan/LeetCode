/*
 *Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 *Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 *For example,
 *Given input array A = [1,1,2],
 *
 *Your function should return length = 2, and A is now [1,2].
 */

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }
        int cur = 0;
        for (int i = 1 ; i < A.length ; i++) {
            if (A[i] != A[cur]) {
                A[++cur] = A[i];
            }
        }
        return cur + 1;
    }
}
