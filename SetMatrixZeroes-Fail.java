/*
 *Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 *click to show follow up.
 *
 *Follow up:
 *Did you use extra space?
 *A straight forward solution using O(mn) space is probably a bad idea.
 *A simple improvement uses O(m + n) space, but still not the best solution.
 *Could you devise a constant space solution?
 */

public class Solution {
    public void setZeroes(int[][] matrix) {
        long mBits = 0;
        long nBits = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0 ; i < m ; i++)
            for (int j = 0 ; j < n ; j++) {
                if (matrix[i][j] == 0) {
                    mBits |= (1L<<i);
                    nBits |= (1L<<j);
                }
            }
        for (int i = 0 ; i < m ; i++)
            for (int j = 0 ; j < n ; j++) {
                if (((mBits>>i) & 1) == 1 || ((nBits>>j) & 1) == 1) {
                    matrix[i][j] = 0;
                }
            }
    }
}
