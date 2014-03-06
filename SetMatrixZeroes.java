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
        boolean firstRow = false;
        boolean firstCol = false;
        int m = matrix.length;
        int n = matrix[0].length;

        //scan first column
        for (int i = 0 ; i < m ; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        //scan first row
        for (int j = 0 ; j < n ; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        //scan non-first cols and rows, store in first col and row
        for (int i = 1 ; i < m ; i++)
            for (int j = 1 ; j < n ; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        //set non-first rows and cols
        for (int i = 1 ; i < m ; i++)
            for (int j = 1 ; j < n ; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

        //set first col
        if (firstCol) {
            for (int i = 0 ; i < m ; i++) {
                matrix[i][0] = 0;
            }
        }
        //set first row
        if (firstRow) {
            for (int j = 0 ; j < n ; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
