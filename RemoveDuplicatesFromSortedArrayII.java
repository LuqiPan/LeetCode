/*
 *Follow up for "Remove Duplicates":
 *What if duplicates are allowed at most twice?
 *
 *For example,
 *Given sorted array A = [1,1,1,2,2,3],
 *
 *Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len <= 2) {
            return len;
        }
        int count = 1;
        int cur = 1;
        for (int i = 1 ; i < len ; i++) {
            if (A[i] == A[i-1]) {
                count++;
                if (count <= 2) {
                    A[cur++] = A[i];
                }
            } else {
                A[cur++] = A[i];
                count = 1;
            }
        }
        return cur;
    }
}
