/*
 *Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 *Note: You can only move either down or right at any point in time.
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] sums = new int[n];

        for (int i = 0 ; i < n ; i++) {
            //watch out the sum here
            if (i == 0) {
                sums[i] = grid[0][i];
            } else {
                sums[i] = grid[0][i] + sums[i-1];
            }
        }
        for (int i = 1 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (j == 0) {
                    sums[j] = grid[i][j] + sums[j];
                } else {
                    sums[j] = grid[i][j] + Math.min(sums[j-1], sums[j]);
                }
            }
        }
        return sums[n-1];
    }
}
