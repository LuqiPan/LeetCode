/*
 *Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 *For example,
 *Given n = 3,
 *
 *You should return the following matrix:
 *[
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 *]
 */

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        helper(result, 1, 0, n);
        return result;
    }
    public void helper(int[][] result, int start, int i, int n) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            result[i][i] = start;
            return;
        }
        for (int y = i ; y < i+n-1 ; y++) {
            result[i][y] = start++;
        }
        for (int x = i ; x < i+n-1 ; x++) {
            result[x][i+n-1] = start++;
        }
        for (int y = i+n-1 ; y > i ; y--) {
            result[i+n-1][y] = start++;
        }
        for (int x = i+n-1 ; x > i ; x--) {
            result[x][i] = start++;
        }
        helper(result, start, i+1, n-2);
    }
}
