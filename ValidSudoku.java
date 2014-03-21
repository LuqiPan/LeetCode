/*
 *Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 *The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 *
 *A partially filled sudoku which is valid.
 *
 *Note:
 *A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0 ; i < 9 ; i++) {
            if (!checkRow(board, i)) {
                return false;
            }
            if (!checkCol(board, i)) {
                return false;
            }
            int x = i / 3;
            int y = i % 3;
            if (!checkSubBox(board, x*3,y*3)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkRow(char[][] board, int row) {
        boolean[] check = new boolean[9];
        for (int i = 0 ; i < 9 ; i++) {
            char c = board[row][i];
            if (c != '.') {
                if (check[c-'1']) {
                    return false;
                } else {
                    check[c-'1'] = true;
                }
            }
        }
        return true;
    }
    public boolean checkCol(char[][] board, int col) {
        boolean[] check = new boolean[9];
        for (int i = 0 ; i < 9 ; i++) {
            char c = board[i][col];
            if (c != '.') {
                if (check[c-'1']) {
                    return false;
                } else {
                    check[c-'1'] = true;
                }
            }
        }
        return true;
    }
    public boolean checkSubBox(char[][] board, int x, int y) {
        boolean[] check = new boolean[9];
        for (int i = 0 ; i < 3 ; i++)
            for (int j = 0 ; j < 3 ; j++) {
                char c = board[x+i][y+j];
                if (c != '.') {
                    if (check[c-'1']) {
                        return false;
                    } else {
                        check[c-'1'] = true;
                    }
                }
            }
        return true;
    }
}
