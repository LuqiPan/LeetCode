/*
 *Follow up for N-Queens problem.
 *
 *Now, instead outputting board configurations, return the total number of distinct solutions.
 */

public class Solution {
    int result;
    public int totalNQueens(int n) {
        int[] pos = new int[n];
        NQ(n, pos, 0);
        return result;
    }
    public void NQ(int n, int[] pos, int depth) {
        if (n == depth) {
            result++;
            return;
        }

        for (int i = 0 ; i < n ; i++) {
            if (checkValid(pos, depth, i)) {
                pos[depth] = i;
                NQ(n, pos, depth + 1);
            } else {
                //alter return to continue and it passed
                //really should watch for this!!!
                continue;
            }
        }
    }
    public boolean checkValid(int[] pos, int depth, int i) {
        for (int j = 0 ; j < depth ; j++) {
            if (pos[j] == i) {
                return false;
            }
            if (Math.abs(pos[j] - i) == Math.abs(j - depth)) {
                return false;
            }
        }
        return true;
    }
}
