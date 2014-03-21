/*
 *Follow up for "Unique Paths":
 *
 *Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 *For example,
 *There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 *[
 *[0,0,0],
 *[0,1,0],
 *[0,0,0]
 *]
 *The total number of unique paths is 2.
 *
 *Note: m and n will be at most 100.
 */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] T = new int[m][n];
        T[0][0] = 1;

        for (int i = 1 ; i < m ; i++) {
            if (obstacleGrid[i][0] == 1) {
                T[i][0] = 0;
            } else {
                T[i][0] = T[i-1][0];
            }
        }

        for (int j = 1 ; j < n ; j++) {
            if (obstacleGrid[0][j] == 1) {
                T[0][j] = 0;
            } else {
                T[0][j] = T[0][j-1];
            }
        }

        for (int i = 1 ; i < m ; i++)
            for (int j = 1 ; j < n ; j++) {
                if (obstacleGrid[i][j] == 1) {
                    T[i][j] = 0;
                } else {
                    T[i][j] = T[i-1][j] + T[i][j-1];
                }
            }

        return T[m-1][n-1];
    }
}
