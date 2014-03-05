/*
 *Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 *Note:
 *You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        //going backwards
        int p = m+n-1;
        int a = m-1;
        int b = n-1;
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[p--] = A[a--];
            } else {
                A[p--] = B[b--];
            }
        }
        if (b >= 0) {
            for (int i = 0 ; i < b+1 ; i++) {
                A[i] = B[i];
            }
        }
    }
}
