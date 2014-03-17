/*
 *Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 *For example,
 *Given the following matrix:
 *
 *[
 *[ 1, 2, 3 ],
 *[ 4, 5, 6 ],
 *[ 7, 8, 9 ]
 *]
 *You should return [1,2,3,6,9,8,7,4,5].
 */

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        helper(matrix, 0, 0, m, n, result);
        return result;
    }
    public void helper(int[][] matrix, int i, int j, int m, int n, ArrayList<Integer> result) {
        if (m == 0 || n == 0) {
            return;
        }
        if (m == 1 && n == 1) {
            result.add(matrix[i][j]);
            return;
        }
        if (m == 1) {
            for (int y = j ; y < j + n ; y++) {
                result.add(matrix[i][y]);
            }
            return;
        }
        if (n == 1) {
            for (int x = i ; x < i + m ; x++) {
                result.add(matrix[x][j]);
            }
            return;
        }

        for (int y = j ; y < j + n - 1 ; y++) {
            result.add(matrix[i][y]);
        }
        for (int x = i ; x < i + m - 1 ; x++) {
            result.add(matrix[x][j+n-1]);
        }
        for (int y = j + n - 1 ; y > j ; y--) {
            result.add(matrix[i+m-1][y]);
        }
        for (int x = i + m - 1 ; x > i ; x--) {
            result.add(matrix[x][j]);
        }
        helper(matrix, i+1, j+1, m-2, n-2, result);
    }
}
