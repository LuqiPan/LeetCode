/*
 *You are given an n x n 2D matrix representing an image.
 *
 *Rotate the image by 90 degrees (clockwise).
 *
 *Follow up:
 *Could you do this in-place?
 */

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int start = 0 ; start < n/2; start++) {
            int end = n - start - 1;
            for (int j = start ; j < end ; j++) {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end-j+start][start];
                matrix[end-j+start][start] = matrix[end][end-j+start];
                matrix[end][end-j+start] = matrix[j][end];
                matrix[j][end] = temp;
            }
        }
    }
}
