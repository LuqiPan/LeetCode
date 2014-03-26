/*
 *The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 *Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 *For example,
 *    There exist two distinct solutions to the 4-queens puzzle:
 *
 *    [
 *    [".Q..",  // Solution 1
 *    "...Q",
 *    "Q...",
 *    "..Q."],
 *
 *    ["..Q.",  // Solution 2
 *    "Q...",
 *    "...Q",
 *    ".Q.."]
 *    ]
 */

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] pos = new int[n];
        NQ(n, result, pos, 0);
        return result;
    }
    public void NQ(int n, ArrayList<String[]> result, int[] pos, int depth) {
        if (n == depth) {
            result.add(convert(pos, n));
            return;
        }

        for (int i = 0 ; i < n ; i++) {
            if (checkValid(pos, depth, i)) {
                pos[depth] = i;
                NQ(n, result, pos, depth + 1);
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
    public String[] convert(int[] pos, int n) {
        String[] result = new String[n];
        for (int i = 0 ; i < n ; i++) {
            String row = new String();
            for (int j = 0 ; j < n ; j++) {
                if (j == pos[i]) {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            result[i] = row;
        }
        return result;
    }
}
