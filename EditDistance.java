/*
 *Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 *You have the following 3 operations permitted on a word:
 *
 *a) Insert a character
 *b) Delete a character
 *c) Replace a character
 */

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] T = new int[len1+1][len2+1];

        for (int i = 0 ; i <= len1 ; i++)
            for (int j = 0 ; j <= len2 ; j++) {
                if (i == 0) {
                    T[0][j] = j;
                    continue;
                }
                if (j == 0) {
                    T[i][0] = i;
                    continue;
                }
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    T[i][j] = T[i-1][j-1];
                } else {
                    T[i][j] = Math.min(Math.min(T[i-1][j-1], T[i-1][j]), T[i][j-1]) + 1;
                }
            }
        return T[len1][len2];
    }
}
