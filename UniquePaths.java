/*
 *A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 *The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 *How many possible unique paths are there?
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] result = new int[n];
        for (int j = 0 ; j < n ; j++) {
            result[j] = 1;
        }
        for (int i = 1 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (j == 0) {
                    continue;
                } else {
                    result[j] = result[j] + result[j-1];
                }
            }
        }
        return result[n-1];
    }
}
