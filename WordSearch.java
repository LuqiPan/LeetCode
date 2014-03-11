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
        int row = board.length;
        if (row == 0 || word.length() == 0) {
            return false;
        }
        int col = board[0].length;

        for (int i = 0 ; i < row ; i++)
            for (int j = 0 ; j < col ; j++) {

                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[row][col];
                    Stack<Integer> coodStack = new Stack<Integer>();
                    Stack<Integer> posStack = new Stack<Integer>();

                    coodStack.push(i * col + j);
                    posStack.push(0);

                    while (!coodStack.empty()) {
                        int cood = coodStack.peek();
                        int x = cood / col;
                        int y = cood % col;
                        int pos = posStack.peek();

                        if (visited[x][y]) {
                            visited[x][y] = false;
                            coodStack.pop();
                            posStack.pop();
                            continue;
                        }

                        if (board[x][y] == word.charAt(pos)) {
                            visited[x][y] = true;
                            if (pos == word.length()-1) {
                                return true;
                            }

                            if (x-1 >= 0 && !visited[x-1][y]) {
                                coodStack.push((x-1)*col+y);
                                posStack.push(pos+1);
                            }
                            if (x+1 < row && !visited[x+1][y]) {
                                coodStack.push((x+1)*col+y);
                                posStack.push(pos+1);
                            }
                            if (y-1 >= 0 && !visited[x][y-1]) {
                                coodStack.push(x*col+y-1);
                                posStack.push(pos+1);
                            }
                            if (y+1 < col && !visited[x][y+1]) {
                                coodStack.push(x*col+y+1);
                                posStack.push(pos+1);
                            }
                        } else {
                            coodStack.pop();
                            posStack.pop();
                        }
                    }
                }
            }
        return false;
    }
}
