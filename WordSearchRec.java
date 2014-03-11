/*
 *Given a 2D board and a word, find if the word exists in the grid.
 *
 *The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *For example,
 *Given board =
 *
 *[
 *    ["ABCE"],
 *    ["SFCS"],
 *    ["ADEE"]
 *]
 *word = "ABCCED", -> returns true,
 *word = "SEE", -> returns true,
 *word = "ABCB", -> returns false.
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0 ; i < board.length ; i++)
        {
            for (int j = 0 ; j < board[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0 ; i < board.length ; i++)
            for (int j = 0 ; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, visited, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        return false;
    }

    public boolean helper(char[][] board, boolean[][] visited, int i, int j, int pos, String word) {
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(pos)) {
            return false;
        }
        if (pos == word.length()-1) {
            return true;
        }

        visited[i][j] = true;

        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
        if (i-1 >= 0) {
            up = helper(board, visited, i-1, j, pos+1, word);
        }
        if (i+1 < board.length) {
            down = helper(board, visited, i+1, j, pos+1, word);
        }
        if (j-1 >= 0) {
            left = helper(board, visited, i, j-1, pos+1, word);
        }
        if (j+1 < board[0].length) {
            right = helper(board, visited, i, j+1, pos+1, word);
        }

        visited[i][j] = false;

        return left | right | up | down;
    }
}
